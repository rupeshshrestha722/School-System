package com.project.service;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.project.dao.ClassDAO;
import com.project.dao.RoleDAO;
import com.project.dao.TeacherDAO;
import com.project.dao.UserDetailsDAO;
import com.project.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class TeacherController {

	@Autowired
	ClassDAO classDAO;

	@Autowired
	TeacherDAO teacherDAO;

	@Autowired
	RoleDAO roleDAO;

	@Autowired
	UserDetailsDAO userDAO;

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Class.class, "schoolClass",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) {
						setValue((text.equals("")) ? null : classDAO
								.getClass(Integer.parseInt((String) text)));
					}
				});
	}

	@Transactional
	@RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
	public String addTeacher(Model model) {

		model.addAttribute("teacher", new Teacher());
		model.addAttribute("classes", classDAO.findAll());
		return "addTeacher";
	}

	@Transactional
	@RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
	public String AddNewTeacher(@Valid Teacher teacher, BindingResult errors,
			Model model, HttpServletRequest request) {

		model.addAttribute("teacher", teacher);

		if (errors.hasErrors()) {
			return "addTeacher";
		}

		if (userDAO.isUserNameAvailable(teacher.getUsername())) {
			teacher.setRole(roleDAO.getRole("teacher"));
			teacherDAO.saveTeacher(teacher);
			model.addAttribute("teacher", new Teacher());
			model.addAttribute("message", "Nauczyciel " + teacher.getFirstName()
					+ " " + teacher.getLastName() + " został dodany.");
		} else {
			model.addAttribute("message", "Nazwa użytkownika jest zajęta.");
		}

		return "addTeacher";
	}

	@RequestMapping(value = "/teachers", method = RequestMethod.GET)
	public String getTeachers(Model model) {

		List<Teacher> teachers = teacherDAO.findAllTeacher();
		
		model.addAttribute("teachers", teachers);
		return "teachers";

	}

	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String getTeacher(Model model, HttpServletRequest request) {

		Teacher teacher = teacherDAO.getTeacher(Integer.parseInt(request
				.getParameter("id")));
		model.addAttribute("teacher", teacher);
		return "teacher";

	}

	@Transactional
	@RequestMapping(value = "/deleteTeacher", method = RequestMethod.GET)
	public String deleteTeacher(Model model, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("message",
				"Nauczyciel został usunięty.");
		teacherDAO.removeTeacher(teacherDAO.getTeacher(Integer.parseInt(request
				.getParameter("id"))));
		return "redirect:/teachers";
	}

	@Transactional
	@RequestMapping(value = "/editTeacher", method = RequestMethod.GET)
	public String editTeacher(Model model, HttpServletRequest request) {

		Teacher teacher = teacherDAO.getTeacher(Integer.parseInt(request
				.getParameter("id")));
		model.addAttribute("teacher", teacher);
		//teacher.setName("UDALO SIE!!!!!!!!!!");
		//teacherDAO.updateTeacher(teacher);

		model.addAttribute("classes", classDAO.findAll());
		return "editTeacher";

	}

	@Transactional
	@RequestMapping(value = "/editTeacher", method = RequestMethod.POST)
	public String editTeacher(@Valid Teacher teacher, BindingResult errors,
			Model model, HttpServletRequest request, RedirectAttributes redirect) {
		
		redirect.addFlashAttribute("message", "Nauczyciel został zmodyfikowany");


		if (errors.hasErrors()) {
			return "editTeacher";
		}
			teacher.setRole(roleDAO.getRole("teacher"));
			teacherDAO.updateTeacher(teacher);
			model.addAttribute("message", "Nauczyciel " + teacher.getFirstName()
					+ " " + teacher.getLastName() + " został zmodyfikowany.");
//		
//
		return "redirect:/teachers";
	}

}
