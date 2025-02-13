package vunh.theodoi.chitieu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vunh.theodoi.chitieu.entities.PlanMonthly;
import vunh.theodoi.chitieu.entities.PlanMonthlyId;

public interface PlanMonthlyRepository extends JpaRepository<PlanMonthly, PlanMonthlyId> {
}
