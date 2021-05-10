package com.app.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.FashionRepository;
import com.app.dto.FashionRegistrationFormDto;
import com.app.exceptions.ProductNotFoundException;
import com.app.pojos.Fashion;
import com.app.pojos.Misc;
import com.app.pojos.Product;
import com.app.pojos.Vendor;
import com.app.pojos.VendorCategory;

@Service
@Transactional
public class FashionServiceImpl implements IFashionService {

	@Autowired
	private FashionRepository fashionRepository;

	@Override
	public String saveFashionItem(FashionRegistrationFormDto fashionDto, List<VendorCategory> vendorCategory,
			String subCategory, Vendor vendor, byte[] imageFile) {
		Fashion fashionItem = fashionDto.getFashionInfo();
		fashionRepository.save(fashionItem);
		fashionItem.setDescription(fashionDto.getDescription());
		fashionItem.setManufactureInformation(fashionDto.getManufactureInformation());
		fashionItem.getManufactureInformation().setManufactureLocation(fashionDto.getAddress());
		fashionItem.setStatus("NEW");
		fashionItem.setpImage(imageFile);
		fashionItem.setBrand(subCategory);
		fashionItem.setDateAdded(LocalDate.now());
		fashionItem.setMisc(new Misc());

		VendorCategory productCategory = vendorCategory.stream().filter(i -> i.getCategoryTitle().equals(subCategory))
				.findAny().get();
		fashionItem.setProductCategory(productCategory);

		return "Fashion Item saved successfully..";
	}

	@Override
	public List<Fashion> fetchAllFashionProducts(int cid, int vid) {
		List<Fashion> allFashions = fashionRepository.fetchAllFashions(cid, vid);
		allFashions.forEach(i -> System.out.println(i));
		return allFashions;
	}

	@Override
	public String deleteFashion(Long pid) {
		fashionRepository.deleteById(pid);
		return "fashion deleted";
	}

	@Override
	public String toogleFashion(Long pid) {
		Product fashion = fashionRepository.findById(pid)
				.orElseThrow(() -> new ProductNotFoundException("product does not exist"));
		if (fashion.getStatus().equals("hide"))
			fashion.setStatus("show");
		else
			fashion.setStatus("hide");
		return "fashion status cahnged sucessfully";
	}

	@Override
	public Fashion getFashion(Long pid) {

		return fashionRepository.findById(pid)
				.orElseThrow(() -> new ProductNotFoundException("could not found product"));
	}

}
