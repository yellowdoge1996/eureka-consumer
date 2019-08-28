package com.example.eurekaconsumer.feignClient;

import com.example.eurekaconsumer.configuration.MultipartSupportConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "eureka-client", configuration = MultipartSupportConfig.class)
public interface UploadService {
    @PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handlerFileUpload(@RequestPart(value = "file") MultipartFile file);
}
