package com.casestudy.ContactApplication.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.casestudy.ContactApplication.entity.User;
import com.casestudy.ContactApplication.model.UserDTO;

@Component
public class UserUtil {
	
	 public static List<UserDTO> convertToUserDTOList(List<User> list) {
	        List<UserDTO> dtoList = new ArrayList<>();
	        for (User user : list)
	            dtoList.add(convertToUserDTO(user));
	        return dtoList;
	    }
	 
	 public static User convertToUser(UserDTO userDTO) {
		 
		 User user = new User();
		 user.setUserId(userDTO.getUserId());
	     user.setPassword(userDTO.getPassword());
		return user;
	 }

	public static UserDTO convertToUserDTO(User user) {
		// TODO Auto-generated method stub
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
        userDTO.setPassword(user.getPassword());
		return userDTO;
	}

}
