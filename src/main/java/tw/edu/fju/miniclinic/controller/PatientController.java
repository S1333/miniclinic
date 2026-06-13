package tw.edu.fju.miniclinic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.edu.fju.miniclinic.model.PatientRepository;

@Controller
public class PatientController {

    @Autowired
    private PatientRepository patientRepo;

    @GetMapping("/patients")
    public String listPatients(Model model) {
        // 將病患資料放入 Model 傳遞給 View
        model.addAttribute("patients", patientRepo.findAll());
        // 對應 templates/patients.html
        return "patients";
    }
}

@RestController class PatientApiController {

    @Autowired
    private PatientRepository patientRepo;

    @GetMapping("/api/patients")
    public List<tw.edu.fju.miniclinic.model.Patient> getPatients() {
        return patientRepo.findAll();
    }
}