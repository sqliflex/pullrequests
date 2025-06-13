import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StatisticsScheduler {

    private final StatisticsService statisticsService;

    public StatisticsScheduler(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    // Scheduled task to update statistics every day at midnight
    @Scheduled(cron = "0 0 0 * * ?") 
    public void updateDailyStatistics() {
        statisticsService.updateStatistics();
        System.out.println("Statistics updated: " + statisticsService.getStatistics());
    }
}
