package com.example.exercise_jparelationi.Service;

import com.example.exercise_jparelationi.ApiResponse.ApiException;
import com.example.exercise_jparelationi.DTO.AddressDTO;
import com.example.exercise_jparelationi.Model.Address;
import com.example.exercise_jparelationi.Model.Teacher;
import com.example.exercise_jparelationi.Repository.AddressRepository;
import com.example.exercise_jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public void addAddress(AddressDTO addressDTO){

        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null) throw new ApiException("Error: teacher not found");

        Address address = new Address(null , addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO){

        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null) throw new ApiException("Error: teacher not found");

        Address address = new Address();

        address.setId(addressDTO.getTeacher_id());
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setTeacher(teacher);


        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if (address == null ) throw new ApiException("Error: address not found");
        addressRepository.deleteById(id);
    }
}
