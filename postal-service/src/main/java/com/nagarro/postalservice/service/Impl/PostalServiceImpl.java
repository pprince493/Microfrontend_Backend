package com.nagarro.postalservice.service.Impl;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.postalservice.constant.Constant;
import com.nagarro.postalservice.converter.Converter;
import com.nagarro.postalservice.dao.PostalRecordDao;
import com.nagarro.postalservice.dto.ApiResponse;
import com.nagarro.postalservice.entity.PostalRecord;
import com.nagarro.postalservice.exception.ResourceNotFound;
import com.nagarro.postalservice.service.PostalService;

@Service("PostalServiceImpl")
public class PostalServiceImpl implements PostalService {

	@Autowired
	private PostalRecordDao postalDao;

	@Autowired
	private Converter converter;

	
	@Override
	public ApiResponse getPostalRecordByPostalCode(long postalCode) {

		final Optional<PostalRecord> postalRecordOptional = postalDao.findById(postalCode);

		if (postalRecordOptional==null) {
			throw new ResourceNotFound(Constant.RECORD_NOT_FOUND+postalCode);
		}

		final com.nagarro.postalservice.dto.PostalRecordDto postalRecordDto = converter
				.postalRecordEntityToPostalRecordDto(postalRecordOptional.get());

		ApiResponse response=new ApiResponse();
		response.setStatusCode(Constant.HTTP_OK);
		response.setMessage(Constant.RECORD_FOUND + postalCode);
		response.setData(postalRecordDto);
		return response;
	}

	@Override
	public ApiResponse verifyPinCodeIsBlackListed(long postalCode) {

		final Optional<PostalRecord> postalRecordOptional = postalDao.findById(postalCode);

		if (postalRecordOptional==null) {
			throw new ResourceNotFound(Constant.RECORD_NOT_FOUND+postalCode);
		}
		
		final boolean isBlackListed=postalRecordOptional.get().isBlackListed();
		
		ApiResponse response=new ApiResponse();
		response.setStatusCode(Constant.HTTP_OK);
		response.setMessage("Success");
		HashMap<String,Object> data=new HashMap<>();
		data.put("isBlackListed", isBlackListed);
		if(isBlackListed) {
			data.put("message",Constant.CITY_NOT_IN_SERVICE);
		}
		response.setData(data);

		return response;
	}
	
//	@Override
//	public boolean savePostalRecordsFromExcleToDb(MultipartFile file) throws IOException {
//		boolean status = false;
//		Set<PostalRecord> postalRecordList = new HashSet<PostalRecord>();
//
//		if (FileHelper.hasExcelFormat(file)) {
//			postalRecordList = FileHelper.excelToEmployeeList(file.getInputStream());
//			postalDao.saveAll(postalRecordList);
//			status = true;
//		}
//		ApiResponse response=new ApiResponse();
//		response.setStatusCode(Constant.HTTP_CREATED);
//		response.setMessage(file.getName()+" UPLOADED SUCCESSFULLY");
//		return status;
//	}



}
