package com.latihan.myapp.core.service;

import com.latihan.myapp.core.service.exception.BusinessServiceException;

public interface Command {
	public void execute() throws BusinessServiceException;
}
