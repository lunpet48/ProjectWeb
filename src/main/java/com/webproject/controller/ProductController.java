package com.webproject.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.webproject.entity.Category;
import com.webproject.entity.Product;
import com.webproject.entity.Store;
import com.webproject.entity.User;
import com.webproject.service.CategoryService;
import com.webproject.service.ProductService;
import com.webproject.service.StorageService;
import com.webproject.service.StoreService;

@Controller
@RequestMapping("vendor/store/product")
public class ProductController {
	@Autowired
	private ProductService productService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private StorageService storageService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serverFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping("")
	public String getAll(Model model, HttpSession session) {
		//User user = (User) session.getAttribute("user");
		Store store = storeService.findByOwnerId(2L);
		List<Product> result = productService.findAllByStoreId(store.get_id());
		model.addAttribute("listProducts", result);
		return "vendor/product/list";
	}

	@GetMapping("create")
	public String create(Model model) {
		Product product = new Product();
		product.setPromotionalPrice(0);
		product.setQuantity(0);
		product.setIsActive(Boolean.TRUE);
		product.setIsSelling(Boolean.TRUE);
		model.addAttribute("product", product);
		return "vendor/product/createProduct";
	}

	@PostMapping("create")
	public String createProduct(Model model, @Valid @ModelAttribute("product") Product product,
			@RequestParam("cateId") Long cateId, @RequestParam("listImagesFile") MultipartFile[] listImages,
			BindingResult result) {
		if (result.hasErrors()) {
			return "vendor/product/createProduct";
		}
		
		Store store = storeService.findByOwnerId(2L);
		product.setStoreId(store);
		
		Optional<Category> cate = categoryService.findById(cateId);
		product.setCategoryId(cate.get());

		if (!listImages[0].isEmpty()) {
			String[] temp = new String[listImages.length];
			int index = 0;
			for (MultipartFile x : listImages) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				temp[index] = storageService.getStorageFilename(x, uuString);
				index++;
			}
			product.setListImages(temp);
			storageService.store(listImages, product.getListImages());
		}
		productService.save(product);
		model.addAttribute("message", "Tạo thành công");
		return "redirect:/vendor/store/product";
	}
}
