package com.webproject.controller;

import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.webproject.entity.Store;
import com.webproject.model.StoreModel;
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
	public String getStore(ModelMap model, HttpSession session) {
		// User user = (User) session.getAttribute("user");
		Long x = (long) 10;
		Store store = storeService.findByOwnerId(x);
		model.addAttribute("store", store);
		return "vendor/store/store";
	}

	@GetMapping("create")
	public String createStore(ModelMap model) {
		StoreModel store = new StoreModel();
		store.setIsActive(false);
		store.setIsOpen(false);
		model.addAttribute("store", store);
		return "vendor/store/createStore";
	}

	@PostMapping("create")
	public ModelAndView create(ModelMap model, @Valid @ModelAttribute("store") StoreModel store, BindingResult result) {

		/*
		 * if (result.hasErrors()) { return new
		 * ModelAndView("vendor/store/createStore"); }
		 */

		Store entity = new Store();
		BeanUtils.copyProperties(store, entity);

		// if (!store.getAvatarFile().isEmpty()) {
		if (true) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			entity.setAvatar(storageService.getStorageFilename(store.getAvatarFile(), uuString));
			storageService.store(store.getAvatarFile(), entity.getAvatar());
		}

		// if (!store.getCoverFile().isEmpty()) {
		if (true) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			entity.setCover(storageService.getStorageFilename(store.getCoverFile(), uuString));
			storageService.store(store.getCoverFile(), entity.getCover());
		}

		// if (store.getFeaturedImagesFile().length != 0) {
		if (true) {
			String[] temp = new String[store.getFeaturedImagesFile().length];
			int index = 0;
			for (MultipartFile x : store.getFeaturedImagesFile()) {
				UUID uuid = UUID.randomUUID();
				String uuString = uuid.toString();
				temp[index] = storageService.getStorageFilename(x, uuString);
				index++;
			}
			entity.setFeaturedImages(temp);
			storageService.store(store.getFeaturedImagesFile(), entity.getFeaturedImages());
		}

		storeService.save(entity);
		model.addAttribute("message", "Tạo thành công");
		return new ModelAndView("vendor/store/createStore", model);
	}

	@PostMapping("update-info")
	public ModelAndView updateInfoStore(ModelMap model, @Valid @ModelAttribute("store") StoreModel store,
			BindingResult result) {
		if (result.hasErrors()) {
			return new ModelAndView("vendor/store/updateInfoStore");
		}
		Store entity = new Store();
		BeanUtils.copyProperties(store, entity);
		storeService.save(entity);
		model.addAttribute("message", "Chỉnh sửa thành công");
		return new ModelAndView("forward:/vendor/store/update-info", model);
	}

	@GetMapping("edit")
	public ModelAndView edit(ModelMap model, HttpSession session) {
		// User temp = (User) session.getAttribute("user");
		Optional<Store> opt = Optional.of(storeService.findByOwnerId(1L));

		StoreModel store = new StoreModel();
		if (opt.isPresent()) {
			Store entity = opt.get();
			BeanUtils.copyProperties(entity, store);
			model.addAttribute("store", store);
			return new ModelAndView("vendor/store", model);
		}
		model.addAttribute("message", "Store không tồn tại");

		return new ModelAndView("forward:vendor/store/create", model);
	}
}
