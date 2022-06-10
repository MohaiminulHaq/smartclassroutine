package com.my.class_routine.util;

import com.my.class_routine.controller.CommonResponse;
import com.my.class_routine.model.AppUser;
import com.my.class_routine.model.BaseEntity;
import com.my.class_routine.repository.AppUserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static com.my.class_routine.util.MessageConstants.*;

public class CommonUtils {

    private AppUserRepository appUserRepo;

    //================================== *** ==================================
    //									Server Message
    //================================== *** ==================================

    public CommonResponse generateSuccessResponse(Object obj, String... message) {
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setData(obj);
        if (message.length > 1 && message[0] != null && message[1] != null) {
            response.setMessage(message[0]);
            response.setMessageBn(message[1]);
        }
        return response;
    }

    public CommonResponse generateErrorResponse(Object obj, String... message) {
        CommonResponse response = new CommonResponse();
        response.setStatus(false);
        response.setData(obj);
        if (message.length > 1 && message[0] != null && message[1] != null) {
            response.setMessage(message[0]);
            response.setMessageBn(message[1]);
        }
        return response;
    }

    public CommonResponse generateErrorResponse(Exception e) {
        CommonResponse response = new CommonResponse();
        response.setStatus(false);
        String msgType = getMessageType(e.getMessage());
        if(msgType.equals("uk") || msgType.equals("re")) {
            response.setMessage(DATA_ALRADY_EXISTS_MESSAGE);
            response.setMessageBn(DATA_ALRADY_EXISTS_MESSAGE_BN);
        }else if(msgType.equals("fk")) {
            response.setMessage(CHILD_RECORD_FOUND);
            response.setMessageBn(CHILD_RECORD_FOUND_BN);
        }else {
            response.setMessage(e.getMessage());
        }

//		e.printStackTrace();

//		System.out.println(e.getMessage());
        return response;
    }

    //================================== *** ==================================
    //								Entity User
    //================================== *** ==================================

    public void setEntryUserInfo(Object obj) {
        BaseEntity entity = (BaseEntity) obj;

        /* set entry date */
        entity.setEntryDate(new Date());

        /* set other information */
        Integer userId = entity.getEntryUser();
        AppUser appUser = appUserRepo.findById(userId).get();



        entity.setEntryAppUserCode(appUser.getEmployeeCode());

    }

    /**
     * first object is current entity from api
     * second object is database entity
     * @param obj
     * @param obj2
     */
    public void setUpdateUserInfo(Object obj, Object obj2) {
        BaseEntity entity = (BaseEntity) obj;
        BaseEntity data = (BaseEntity) obj2;

        /* set previous entry User Info */
        entity.setEntryUser(data.getEntryUser());
        entity.setEntryDate(data.getEntryDate());

        /* set update date */
        entity.setUpdateDate(new Date());

        /* set other information */
        Integer userId = entity.getUpdateUser();
        AppUser appUser = appUserRepo.findById(userId).get();
        entity.setUpdateAppUserCode(appUser.getEmployeeCode());

    }

    public PageRequest getPageRequest(int page, int size) {




        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("id").descending());
        return pageRequest;
    }



    //================================== *** ==================================
    //									Helper
    //================================== *** ==================================

    public String commonCode(String str, String lastNumber) {
        return str.concat(lastNumber);
    }

    private String getMessageType(String message) {
        System.out.println("12 > " + message);
//    	System.out.println("13 > " + message.substring(52,54));
        if(message != null && message.length() > 55) {
            return message.substring(52,54);
        }
        return "";
    }

    public String getRendom4Digit() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public String generateCode(String prefix, Integer maxId, Integer totalDigit) {
        String padding = String.format("%0"+totalDigit+"d" , maxId);
        return prefix.concat(padding);
    }

//    public MenuItem getCommonModule() {
//        MenuItem module = new MenuItem();
//        module.setId(308);
//        return module;
//    }

    //================================== *** ==================================
    //									Date Helper
    //================================== *** ==================================

    public String formateSqlDate(Date sqlDate) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(sqlDate);
    }

    public String formateSqlTime(String sqlTime) {
        try {
            DateFormat sqlTimeFormat = new SimpleDateFormat("HH:mm");
            Date sTime = sqlTimeFormat.parse(sqlTime);
            DateFormat formTimeFormat = new SimpleDateFormat("hh:mm a");
            return formTimeFormat.format(sTime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }

    }





}
