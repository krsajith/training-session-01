package com.unnathy.trainingservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-registration")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SignupController {

    private final CourseRegistrationRepository courseRegistrationRepository;

    public SignupController(CourseRegistrationRepository courseRegistrationRepository) {
        this.courseRegistrationRepository = courseRegistrationRepository;
    }

    @PostMapping
    public CourseRegistration register(@RequestBody CourseRegistration courseRegistration) {
        return courseRegistrationRepository.save(courseRegistration);
    }

    @GetMapping
    public List<CourseRegistration> getAllRegistration(@RequestParam(value = "courseName",required = false) String courseName) {
        if(courseName!=null){
            return courseRegistrationRepository.findByCourseName(courseName);
        }
        return courseRegistrationRepository.findAll();
    }

    @GetMapping("/{id}")
    public CourseRegistration getById(@PathVariable(value = "id",required = false) Integer id) {
        return courseRegistrationRepository.findById(id).orElse(null);
    }

}
