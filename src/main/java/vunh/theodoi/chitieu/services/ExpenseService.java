package vunh.theodoi.chitieu.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import vunh.theodoi.chitieu.common.TimeCommon;
import vunh.theodoi.chitieu.dto.Expense;
import vunh.theodoi.chitieu.dto.requests.ExpenseRecord;
import vunh.theodoi.chitieu.dto.responses.ExpenseResponses;
import vunh.theodoi.chitieu.entities.Transaction;
import vunh.theodoi.chitieu.entities.TransactionId;
import vunh.theodoi.chitieu.repositories.CategoryRepository;
import vunh.theodoi.chitieu.repositories.TransactionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ExpenseService {
    CategoryRepository categoryRepo;
    TransactionRepository transactionRepo;

    public boolean checkLegalData(ExpenseRecord expenseRequest) {
        String category = expenseRequest.category();
        if (category != null)
            return categoryRepo.isExists("huyvu", category) > 0;
        return true;
    }

    public void save(ExpenseRecord expenseRequest) {
        Transaction transaction = new Transaction();

        LocalDate date = TimeCommon.getLocalDate(expenseRequest.date());
        String monthId = TimeCommon.formatMonth(date);
        Long transactionNo =  transactionRepo.countTransactionsInMonth(monthId, "huyvulccd");
        TransactionId id = new TransactionId(monthId, "huyvulccd", transactionNo);

        transaction.setId(id);
        transaction.setDayOfMonth(date.getDayOfMonth());
        transaction.setMonthFinance(monthId);
        transaction.setAmount(expenseRequest.amount());
        String[] category = expenseRequest.category().split("-");
        transaction.setCategory(category[0]);
        transaction.setSubCategory(category[1]);
        transaction.setNote(expenseRequest.note());
        transactionRepo.save(transaction);
    }

    public ExpenseResponses listExpenses(String month) {
        ExpenseResponses resp = new ExpenseResponses();
        resp.setMonthYear(month);
        resp.setExpenses(dump());
        return resp;
    }

    private List<Expense> dump() {
        return List.of(
                new Expense("0","Mua 2 áo uniqlo",1800,"Khác",""),
                new Expense("1","Trả nợ shoppee",308,"Khác",""),
                new Expense("1","Nạp tiền điện thoại",130,"Cố định",""),
                new Expense("1","Phái sinh",500,"Khác",""),
                new Expense("2","Đi xe XanhSM",60,"Thiết yếu",""),
                new Expense("3","Ăn bánh mì",20,"Thiết yếu",""),
                new Expense("1","Ăn trưa",35,"Thiết yếu",""),
                new Expense("1","Ăn tối",255,"Thiết yếu",""),
                new Expense("4","Ăn trưa",35,"Thiết yếu",""),
                new Expense("4","Mua đồ ăn tối",50,"Cố định","50% 10 trứng + rau cải"),
                new Expense("4","Mua đồ nấu ăn",66,"Cố định","50% Hạt nêm, nước mắm, hảo hảo"),
                new Expense("4","Mang đồ ăn xuống",500,"Khác",""),
                new Expense("5","Mua 4English",750,"Khác",""),
                new Expense("7","Ăn sáng",13,"Khác",""),
                new Expense("7","Mua cường lực",88,"Thiết yếu",""),
                new Expense("7","Mua gạo",135,"Thiết yếu","50% st25"),
                new Expense("8","Chơi piano",50,"Giải trí",""),
                new Expense("8","Mua thịt gà",50,"Thiết yếu","50%"),
                new Expense("8","Mua rau",13,"Thiết yếu","50%"),
                new Expense("9","Mua đồ làm đồ án",77,"Thiết yếu","")
                );
    }
}
