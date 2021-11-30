package com.hrms.core.utilities.results;

public class DataResult<TEntity> extends Result {
    private TEntity data;

    public DataResult(TEntity data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    public DataResult(TEntity data, boolean success) {
        super(success);
        this.data = data;
    }

    public TEntity getData() {
        return this.data;
    }
}
