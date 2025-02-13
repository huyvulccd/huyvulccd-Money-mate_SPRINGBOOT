package vunh.theodoi.chitieu.common;

import vunh.theodoi.chitieu.dto.requests.ExpenseRecord;

public class ValidationCommon {
    public static boolean validate(ExpenseRecord expenseRequest) {
        if (expenseRequest.isPast() && !TimeCommon.formatYYYY_MM_DD(expenseRequest.date()))
            return false;

        if (expenseRequest.amount() <= 0)
            return false;

        return expenseRequest.category() != null && !expenseRequest.category().isEmpty();
    }
}
