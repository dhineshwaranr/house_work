package com.house.work.admin;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.dandelion.datatables.core.ajax.DataSet;
import com.github.dandelion.datatables.core.ajax.DatatablesCriterias;
import com.github.dandelion.datatables.core.ajax.DatatablesResponse;
import com.github.dandelion.datatables.extras.spring3.ajax.DatatablesParams;
import com.house.work.dto.UserDto;
import com.house.work.entity.User;
import com.house.work.helpers.DandelionHelper;
import com.house.work.repository.UserRepository;

@Controller("adminCustomerController")
@RequestMapping(value="admin/customer")
public class CustomerController {

	private UserRepository userRepository;
	
	@Autowired
	public CustomerController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public String list() {
        return "admin/customer/list";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DatatablesResponse<UserDto> list(@DatatablesParams DatatablesCriterias datatablesCriterias) {
		System.out.println("1");
        Page<User> page = null;
        Pageable pageable = DandelionHelper.buildPageable(datatablesCriterias);
        System.out.println("111");
        if (!StringUtils.isBlank(datatablesCriterias.getSearch())) {
            page = userRepository.findByNameAndByActiveAndByRole(
                    "%" + datatablesCriterias.getSearch().toLowerCase() + "%",
                    1, 1,
                    pageable);
        } else {
        	System.out.println("In Here");
            //page = userRepository.findByActiveAndByRegisterAsCustomer(1, 1, pageable);
        	page = userRepository.findAll(pageable);
        }

        DataSet<UserDto> userDataSet = new DataSet<>(getUserDtoList(page.getContent()), page.getTotalElements(), page.getTotalElements());
        //System.out.println(userDataSet.getTotalRecords());
        return DatatablesResponse.build(userDataSet, datatablesCriterias);
    }
	
	
	private List<UserDto> getUserDtoList(List<User> users) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user.getId(), user.getName(), user.getLastName(), user.getEmail());
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
	
}
