package com.nagarro.postalservice.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.postalservice.dto.PostalRecordDto;

@Component
public class Converter {

	@Autowired
	private ModelMapper modelMapper;
	
	
	 public PostalRecordDto postalRecordEntityToPostalRecordDto(com.nagarro.postalservice.entity.PostalRecord postalRecordEntity) {
		return this.modelMapper.map(postalRecordEntity,PostalRecordDto.class);
	}
	
	
	public com.nagarro.postalservice.entity.PostalRecord postalRecordDtoToPostalRecordEntity(PostalRecordDto postalRecordDto) {
		return this.modelMapper.map(postalRecordDto,com.nagarro.postalservice.entity.PostalRecord.class);
	}
}
