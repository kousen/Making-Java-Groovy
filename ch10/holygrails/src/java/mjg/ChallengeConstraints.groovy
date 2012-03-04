package mjg

constraints = {
    startDate validator: { value, challenge ->
        value >= challenge.task.startDate
    }
    endDate validator: { value, challenge ->
        value >= challenge.startDate
    }
}