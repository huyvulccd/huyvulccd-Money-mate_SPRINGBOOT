package vunh.theodoi.chitieu.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vunh.theodoi.chitieu.common.ValidationCommon;
import vunh.theodoi.chitieu.dto.requests.ExpenseRecord;
import vunh.theodoi.chitieu.dto.responses.ExpenseResponses;
import vunh.theodoi.chitieu.services.ExpenseService;

@RestController
@RequestMapping("/expenses")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@CrossOrigin(origins = "http://localhost:5173")
public class ExpensesController {

    ExpenseService service;

    @GetMapping("/get/")
    public ResponseEntity<ExpenseResponses> listExpenses(@RequestParam String month) {
        ExpenseResponses responses = service.listExpenses(month);
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/take-note")
    public ResponseEntity<Void> takeNote(@RequestBody ExpenseRecord expenseRequest) {
        if (ValidationCommon.validate(expenseRequest))
            return ResponseEntity.badRequest().build();

        if (service.checkLegalData(expenseRequest)) {
            service.save(expenseRequest);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
