package org.juhee.letter;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.juhee.book.chap11.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LetterController {


	@Autowired
	LetterDao letterDao;

	/**
	 * 받은 목록
	 */
	@GetMapping("/letter/listOfReceiver")
	public void listOfReceiver(@SessionAttribute("MEMBER") Member member,
			@RequestParam("receiverId") String receiverId,
			Model model) {
		if (member.getMemberId().equals(receiverId)) {
			List<Letter> letters = letterDao
					.listLettersOfReceiver(receiverId);
			model.addAttribute("letters", letters);			
		}
	}

	/**
	 * 보낸 목록
	 */
	@GetMapping("/letter/listOfSender")
	public void listOfSender(@SessionAttribute("MEMBER") Member member,
			@RequestParam("senderId") String senderId,
			Model model) {
		if (member.getMemberId().equals(senderId)) {
			List<Letter> letters = letterDao
					.listLettersOfSender(senderId);
			model.addAttribute("letters", letters);
		}
	}

	/**
	 * 보기
	 */
	@GetMapping("/letter/view")
	public void view(@RequestParam("letterId") String letterId,
			@SessionAttribute("MEMBER") Member member, Model model) {
		Letter letter = letterDao.getLetter(letterId, member.getMemberId());
		model.addAttribute("letter", letter);
	}

	/**
	 * 편지쓰기화면
	 */
	@GetMapping("/letter/addForm")
	public void addForm(HttpSession session) {		
	}

	/**
	 * 편지 저장
	 */
	@PostMapping("/letter/add")
	public String add(Letter letter, @SessionAttribute("MEMBER") Member member) {
		letter.setSenderId(member.getMemberId());
		letter.setSenderName(member.getName());
		letterDao.addLetter(letter);
		return "redirect:/app/members";
	}

	/**
	 * 편지 삭제
	 */
	@GetMapping("/letter/delete")
	public String delete(@RequestParam("letterId") String letterId,
			@RequestParam("senderId") String senderId,
			@RequestParam("receiverId") String receiverId,
			@SessionAttribute("MEMBER") Member member) {
		if (member.getMemberId().equals(senderId))
			letterDao.deleteLetter(letterId, senderId);
		else if(member.getMemberId().equals(receiverId))
			letterDao.deleteLetter(letterId, receiverId);
		return "redirect:/app/members";	
	}
}