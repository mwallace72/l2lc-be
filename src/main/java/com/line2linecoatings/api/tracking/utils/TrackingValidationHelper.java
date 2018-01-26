package com.line2linecoatings.api.tracking.utils;

import com.line2linecoatings.api.tracking.models.Employee;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class TrackingValidationHelper {
    public static final Log log = LogFactory.getLog(TrackingValidationHelper.class);

    public TrackingError validateEmployee(Employee employee) {

        log.info("Start of validateEmployee");
        TrackingError error = null;
        List<String> errorMessages = new ArrayList<>();
        if (StringUtils.isEmpty(employee.getFirstName())) {
            errorMessages.add("Invalid Employee First Name");
        }

        if (StringUtils.isEmpty(employee.getLastName())) {
            errorMessages.add("Invalid Employee Last Name");
        }

        if (!errorMessages.isEmpty()) {
            error = new TrackingError();
            error.setErrorMessages(errorMessages);
            error.setStatus(Response.Status.NOT_ACCEPTABLE);
        }
        log.info("End of validateEmployee");
        return error;
    }

}