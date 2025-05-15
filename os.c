#include <stdio.h>

struct Process {
    int pid;       
    int burst_time; 
    int arrival_time; 
    int waiting_time; 
    int turnaround_time; 
    int completion_time;
};

void sort_by_arrival(struct Process p[], int n) {
    struct Process temp;
    for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
            if(p[i].arrival_time > p[j].arrival_time) {
                temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
    }
}

void calculate_completion_time(struct Process p[], int n) {
    p[0].completion_time = p[0].arrival_time + p[0].burst_time; 
    for(int i = 1; i < n; i++) {

        if(p[i].arrival_time > p[i-1].completion_time) {
            p[i].completion_time = p[i].arrival_time + p[i].burst_time;
        } else {
            p[i].completion_time = p[i-1].completion_time + p[i].burst_time;
        }
    }
}

void calculate_turnaround_time(struct Process p[], int n) {
    for(int i = 0; i < n; i++) {
        p[i].turnaround_time = p[i].completion_time - p[i].arrival_time; // TAT = CT - AT
    }
}

void calculate_waiting_time(struct Process p[], int n) {
    for(int i = 0; i < n; i++) {
        p[i].waiting_time = p[i].turnaround_time - p[i].burst_time; // WT = TAT - BT
    }
}

float calculate_average_waiting_time(struct Process p[], int n) {
    float sum = 0.0;
    for(int i = 0; i < n; i++) {
        sum += p[i].waiting_time;
    }
    return sum / n;
}

float calculate_average_turnaround_time(struct Process p[], int n) {
    float sum = 0.0;
    for(int i = 0; i < n; i++) {
        sum += p[i].turnaround_time;
    }
    return sum / n;
}

void display_results(struct Process p[], int n) {
    printf("\nProcess  Arrival Time  Burst Time  Completion Time  Turnaround Time  Waiting Time\n");

    for(int i = 0; i < n; i++) {
        printf("Process %d    %d             %d            %d                %d                %d\n", 
                p[i].pid, p[i].arrival_time, p[i].burst_time, p[i].completion_time, p[i].turnaround_time, p[i].waiting_time);
    }

    printf("\nAverage Waiting Time: %.2f", calculate_average_waiting_time(p, n));
    printf("\nAverage Turnaround Time: %.2f\n", calculate_average_turnaround_time(p, n));
}

int main() {
    int n;
    printf("Enter number of processes: ");
    scanf("%d", &n);

    struct Process processes[n];

    for(int i = 0; i < n; i++) {
        processes[i].pid = i + 1;
        printf("Enter Burst Time for Process %d: ", i + 1);
        scanf("%d", &processes[i].burst_time);
        printf("Enter Arrival Time for Process %d: ", i + 1);
        scanf("%d", &processes[i].arrival_time);
    }

    sort_by_arrival(processes, n);

    calculate_completion_time(processes, n);
    calculate_turnaround_time(processes, n);
    calculate_waiting_time(processes, n);

    display_results(processes, n);

    return 0;
}