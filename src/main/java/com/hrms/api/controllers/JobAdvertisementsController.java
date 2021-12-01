package com.hrms.api.controllers;

import com.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getAllByReleaseDateDesc")
    public DataResult<List<JobAdvertisement>> getAllByReleaseDateDesc() {
        return this.jobAdvertisementService.getAllByReleaseDateDesc();
    }

    @GetMapping("/getByEmployer")
    public DataResult<List<JobAdvertisement>> getByEmployer(@RequestParam int employerId) {
        return this.jobAdvertisementService.getByEmployer(employerId);
    }
}
