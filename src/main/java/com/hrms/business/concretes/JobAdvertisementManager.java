package com.hrms.business.concretes;

import com.hrms.business.abstracts.JobAdvertisementService;
import com.hrms.core.utilities.results.DataResult;
import com.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),"İş ilanları başarıyla listelendi.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByReleaseDateDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"releaseDate");
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "İş ilanları tarihe göre en yeniden en eskiye sıralandı.");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEmployer(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployerId(employerId), "Belirtilen firmanın iş ilanları listelendi.");
    }
}
