package com.ojas.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ojas.model.Home;
import com.ojas.model.Member;
import com.ojas.model.MemberList;

@Controller
public class HomeController {
	@Autowired
	private HibernateTemplate template;

	@PostMapping("/save")
	public Home save(@RequestBody Home home) {
		return (Home) template.save(home);
	}

	@GetMapping
	public String getRegHome(ModelMap model) {
		model.addAttribute("homeList", template.loadAll(Home.class));
		return "Home";

	}

	@GetMapping("/getMembers/{id}")
	public @ResponseBody List<Member> getMembers(@PathVariable String id, ModelMap map) {
		if (id.equals("select"))
			return template.loadAll(Member.class);

		Home list = template.get(Home.class, Integer.parseInt(id));
		List<Member> list2 = list.getMembers();
		System.out.println(list.getMembers());
		map.addAttribute("members", list2);
		return list.getMembers();

	}

	@PostMapping("/update")
	@Transactional
	public void update(@ModelAttribute("memberList") MemberList mem, ModelMap model) {
		System.out.println("from update");
		List<Member> contacts = mem.getMembers();
		if (null != contacts && contacts.size() > 0) {
			for (Member contact : contacts) {
				System.out.println(contact);
				Member m = new Member();
				m.setConcent(contact.isConcent());
				m.setId(contact.getId());
				m.setName(contact.getName());
				template.saveOrUpdate(m);

			}
		}

	}
}
