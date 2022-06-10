package com.my.class_routine.controller;

import com.my.class_routine.model.StudentDetails;
import com.my.class_routine.service.StudentService;
import com.my.class_routine.util.CommonUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.my.class_routine.util.ApiConstants.*;
import static com.my.class_routine.util.MessageConstants.*;

@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StudentDetailsController {

    private final CommonUtils commonUtils;


    private final StudentService service;

    /* utils */

   // private final UserTokenRequestUtils authTokenUtils;

    @PostMapping
    public CommonResponse save(@RequestBody StudentDetails body, HttpServletRequest request){
        try {
//            body.setEntryUser(authTokenUtils.getUserIdFromRequest(request));
            return commonUtils.generateSuccessResponse(service.save(body), SAVE_MESSAGE, SAVE_MESSAGE_BN);
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }

    @PutMapping
    public CommonResponse update(@RequestBody StudentDetails body, HttpServletRequest request){
        try {
           // body.setUpdateUser(authTokenUtils.getUserIdFromRequest(request));
            return commonUtils.generateSuccessResponse(service.update(body), UPDATE_MESSAGE, UPDATE_MESSAGE_BN);
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }

    @DeleteMapping
    public CommonResponse delete(@RequestBody StudentDetails body){
        try {
            return commonUtils.generateSuccessResponse(service.delete(body), DELETE_MESSAGE, DELETE_MESSAGE_BN);
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }

    @GetMapping
    public CommonResponse getAll(){
        try {
            return commonUtils.generateSuccessResponse(service.getAll());
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }

    @GetMapping( value = ACTIVE_PATH, produces = EXTERNAL_MEDIA_TYPE)
    public CommonResponse getAllActive(){
        try {
            return commonUtils.generateSuccessResponse(service.getAllActive());
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }


    @GetMapping( value = PAGEABLE_PATH, produces = EXTERNAL_MEDIA_TYPE)
    public CommonResponse getPagableList(@PathVariable(PAGEABLE_PAGE) int page, @PathVariable(PAGEABLE_SIZE)int size){
        try {
            return commonUtils.generateSuccessResponse(service.getPageableList(page,size));
        } catch (Exception e) {
            return commonUtils.generateErrorResponse(e);
        }
    }

}
