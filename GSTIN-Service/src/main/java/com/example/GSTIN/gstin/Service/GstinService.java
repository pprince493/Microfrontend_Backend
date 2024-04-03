package com.example.GSTIN.gstin.Service;

import com.example.GSTIN.gstin.Dto.ApiResponse;
import com.example.GSTIN.gstin.Dto.GstinDetailResponse;
import com.example.GSTIN.gstin.Dto.GstinDummyResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GstinService {

    GstinDetailResponse saveGstinDetails(double longitude, double latitude, String panNumber, String gstin, String userId, MultipartFile file);
    List<GstinDummyResponse> getAllGstinByPanNumber(String panNumber);
}
