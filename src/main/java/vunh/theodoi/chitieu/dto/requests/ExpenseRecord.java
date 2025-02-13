package vunh.theodoi.chitieu.dto.requests;

public record ExpenseRecord(
        boolean isPast,
        String title,
        long amount,
        String category,
        String date,
        String note
) {
}
