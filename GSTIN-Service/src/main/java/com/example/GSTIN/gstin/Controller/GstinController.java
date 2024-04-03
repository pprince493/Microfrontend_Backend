package com.example.GSTIN.gstin.Controller;

import com.example.GSTIN.gstin.Constant.Constant;
import com.example.GSTIN.gstin.Dao.GstinDummyRepository;
import com.example.GSTIN.gstin.Dto.ApiResponse;
import com.example.GSTIN.gstin.Dto.GstinDetailResponse;
import com.example.GSTIN.gstin.Dto.GstinDummyResponse;
import com.example.GSTIN.gstin.Entity.GstinDummyDetails;
import com.example.GSTIN.gstin.Service.GstinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/gstin")
@CrossOrigin
public class GstinController {

    @Autowired
    @Qualifier("GstinServiceImpl")
    private GstinService gstinService;

    @Autowired
    private GstinDummyRepository gstinDummyRepository;

    @PostMapping("/data")
    public ResponseEntity<ApiResponse> saveGstinDetails( @RequestParam(name="longitude") double longitude, @RequestParam("latitude") double latitude,@RequestParam String userId, @RequestParam String panNumber, @RequestParam String gstin, @RequestParam MultipartFile file){
        GstinDetailResponse data = gstinService.saveGstinDetails(longitude,latitude,panNumber, gstin, userId, file);
        ApiResponse apiResponse = new ApiResponse(null, HttpStatus.CREATED.value(), Constant.GSTIN_DETAILS_SAVED_SUCCESS,data );
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);

    }


//    @PostMapping("/addingdata")
//    public ResponseEntity<ApiResponse> postController(@RequestBody GstinDummyDetails gstinDummyDetails){
//        gstinDummyDetails.setDateOfRegistration(LocalDate.of(1990, 12, 3));
//        GstinDummyDetails data = gstinDummyRepository.save(gstinDummyDetails);
//
//        ApiResponse apiResponse = new ApiResponse(null, HttpStatus.CREATED.value(), Constant.GSTIN_DETAILS_SAVED_SUCCESS, data);
//        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
//    }


    @GetMapping()
    public ResponseEntity<ApiResponse> getAllByPanNumber(@RequestParam String panNumber){
        List<GstinDummyResponse> gstinDummyResponseList = gstinService.getAllGstinByPanNumber(panNumber);
        ApiResponse apiResponse = new ApiResponse(null, HttpStatus.OK.value(), "Successfully!!", gstinDummyResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


}
