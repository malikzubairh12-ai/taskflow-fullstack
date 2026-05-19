package com.hasan.taskflow.dto;

public record TaskStatsResponse(long total, long todo, long inProgress, long done) {}
