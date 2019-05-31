package org.juhee.letter;

import org.juhee.book.chap11.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LetterController {

	@GetMapping("/letter/listOfReceiver")
	public void listOfReceiver(@SessionAttribute("MEMBER") Member member
			Model model) {
		
	}
	
}
