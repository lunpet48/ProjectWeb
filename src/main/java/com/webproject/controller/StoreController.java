package com.webproject.controller;

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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.webproject.entity.Store;
import com.webproject.entity.User;
import com.webproject.service.StorageService;
import com.webproject.service.StoreService;

@Controller
@RequestMapping("vendor/store")
public class StoreController {
	@Autowired
	private StoreService storeService;

	@Autowired
	private StorageService storageService;

	@GetMapping("images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serverFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	@GetMapping("")
	public String getStore(Model model, HttpSession session) {
		// User user = (User) session.getAttribute("user");
		Long x = (long) 2;
		Store store = storeService.findByOwnerId(x);
		model.addAttribute("store", store);
		return "vendor/store/store";
	}

	@GetMapping("create")
	public String createStore(ModelMap model) {
		Store store = new Store();
		store.setIsActive(false);
		store.setIsOpen(false);
		model.addAttribute("store", store);
		return "vendor/store/createStore";
	}

	@PostMapping("create")
	public String create(Model model, @Valid @ModelAttribute("store") Store store,
			@RequestParam("avatarFile") MultipartFile avatarFile,
			@RequestParam("featuredImagesFile") MultipartFile[] featuredImagesFile,
			@RequestParam("coverFile") MultipartFile coverFile, BindingResult result) {

		if (result.hasErrors()) {
			return "vendor/store/createStore";
		}

		if (!avatarFile.isEmpty()) { // if (true) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			store.setAvatar(storageService.getStorageFilename(avatarFile, uuString));
			storageService.store(avatarFile, store.getAvatar());
		}

		if (!coverFile.isEmpty()) { // if (true) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			store.setCover(storageService.getStorageFilename(coverFile, uuString));
			storageService.store(coverFile, store.getCover());
		}

		if (!featuredImagesFile[0].isEmpty()) { // if (true) {
			String[] temp = new String[featuredImagesFile.length];
			int index = 0;
			for (MultipartFile x : featuredImagesFile) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				temp[index] = storageService.getStorageFilename(x, uuString);
				index++;
			}
			store.setFeaturedImages(temp);
			storageService.store(featuredImagesFile, store.getFeaturedImages());
		}
		storeService.save(store);
		model.addAttribute("message", "Tạo thành công");
		return "redirect:/vendor/store";
	}

	@PostMapping("update-info")
	public String updateInfoStore(Model model, @Valid @ModelAttribute("store") Store store,
			@RequestParam("_id") Long id, @RequestParam("avatarFile") MultipartFile avatarFile,
			@RequestParam("featuredImagesFile") MultipartFile[] featuredImagesFile,
			@RequestParam("coverFile") MultipartFile coverFile, BindingResult result) throws Exception {

		if (result.hasErrors()) {
			return "vendor/store/editStore";
		}

		store.set_id(id);

		if (!avatarFile.isEmpty()) {
			// if (false) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			store.setAvatar(storageService.getStorageFilename(avatarFile, uuString));
			storageService.store(avatarFile, store.getAvatar());
		}

		if (!coverFile.isEmpty()) {
			// if (false) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			store.setCover(storageService.getStorageFilename(coverFile, uuString));
			storageService.store(coverFile, store.getCover());
		}

		if (!featuredImagesFile[0].isEmpty()) {
			String[] temp = new String[featuredImagesFile.length];
			int index = 0;
			for (MultipartFile x : featuredImagesFile) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				temp[index] = storageService.getStorageFilename(x, uuString);
				index++;
			}
			store.setFeaturedImages(temp);
			storageService.store(featuredImagesFile, store.getFeaturedImages());
		}
		storeService.save(store);
		// storeService.updateStore(store);
		model.addAttribute("message", "Chỉnh sửa thành công");
		return "vendor/store/store";
	}

	@GetMapping("edit")
	public String edit(Model model, HttpSession session) {
		// User temp = (User) session.getAttribute("user");
		Store store = storeService.findByOwnerId(2L);
		if (store != null) {
			model.addAttribute("store", store);
			return "vendor/store/editStore";
		}
		model.addAttribute("message", "Store không tồn tại");

		return "forward:vendor/store/edit";
	}

	@GetMapping("delete")
	public String delete(Model model, @RequestParam(name = "_id") Long id) {
		//User
		Optional<Store> opt = storeService.findById(id);
		if(opt.isPresent())
		{
			Store store = opt.get();
			store.setOwnerId(null);
			storeService.save(store);
		}
		model.addAttribute("message", "Xóa thành công");
		return "redirect:/vendor/store";
	}
}
