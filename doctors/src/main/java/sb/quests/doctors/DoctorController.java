package sb.quests.doctors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DoctorController {

    @GetMapping("/doctor/1")
    @ResponseBody
    public String doctorHartnell() {
        return "William Hartnell";
    }

    @GetMapping("/doctor/10")
    @ResponseBody
    public String doctorTennant() {
        return "David Tennant";
    }

    @GetMapping("/doctor/13")
    @ResponseBody
    public String doctorWhittaker() {
        return "Jodie Whittaker";
    }

}
