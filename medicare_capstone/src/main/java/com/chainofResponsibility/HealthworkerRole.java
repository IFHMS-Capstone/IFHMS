package com.chainofResponsibility;

import java.util.Scanner;

import com.healthworkers.HealthWorker;
import com.healthworkers.HealthWorkerFactory;

public class HealthworkerRole implements IRole {
    Scanner scanner = new Scanner(System.in);

    private IRole role;

    @Override
    public void setnextRole(IRole role) {
        this.role = role;

    }

    @Override
    public void execute(String myrole) {
        if (myrole.equals("health worker")) {
            // if healthyworker select typr of healthyworker
            int i = 0;
            while (i < 2) {
                System.out.println("\n...........WHAT KIND OF HEALTH WORKER ARE YOU?....... ");
                System.out.println("1.Doctor ");
                System.out.println("2.Nurse");
                System.out.print("Choose an option: ");
                Integer healthWorkerType = scanner.nextInt();

                HealthWorker healthyWorker = HealthWorkerFactory.getHealthyWorker(healthWorkerType);
                healthyWorker.templateMethod();

                i++;

            }

        } else {
            System.out.println("You have no role in the system");
        }
    }

}
