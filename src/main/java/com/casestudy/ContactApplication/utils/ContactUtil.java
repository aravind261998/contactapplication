package com.casestudy.ContactApplication.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.casestudy.ContactApplication.entity.Contact;
import com.casestudy.ContactApplication.model.ContactDTO;

@Component
public class ContactUtil {

    public static List<ContactDTO> convertToContactDTOList(List<Contact> list) {
        List<ContactDTO> dtoList = new ArrayList<>();
        for (Contact contact : list)
            dtoList.add(convertToContactDTO(contact));
        return dtoList;
    }

    public static Contact convertToContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        contact.setId(contactDTO.getId());
        contact.setFirstName(contactDTO.getFirstName());
        contact.setLastName(contactDTO.getLastName());
        contact.setAge(contactDTO.getAge());
        contact.setEmailId(contactDTO.getEmailId());
        contact.setGender(contactDTO.getGender());
        contact.setRelation(contactDTO.getRelation());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());
//        contact.setImage(contactDTO.getImage());
        return contact;
    }

    public static ContactDTO convertToContactDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setFirstName(contact.getFirstName());
        contactDTO.setLastName(contact.getLastName());
        contactDTO.setAge(contact.getAge());
        contactDTO.setEmailId(contact.getEmailId());
        contactDTO.setGender(contact.getGender());
        contactDTO.setRelation(contact.getRelation());
        contactDTO.setPhoneNumber(contact.getPhoneNumber());
//        contactDTO.setImage(contact.getImage());
        return contactDTO;
    }
}