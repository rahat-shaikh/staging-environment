# The Rehearsal
## The Rehearsal is an application that can allow developers to claim a staging environment for their testing

## Prerequisite:
### 1. Java 8+
### 2. Maven

## Assumptions:
### For the purpose of this exercise,
#### Two environments are setup 'North' and 'South'
#### Three developers are setup 'tom@gmail.com', 'jerry@gmail.com' and 'simba@gmail.com'
#### The operations allowed in this exercise are View, Reserve and Cancel 
#### A developer cannot claim more than 1 environment
#### A developer cannot claim for more than 5 days
#### All test cases aren't written due to time constraints
#### An access token (dummy) has been created for revoking environment after X days
#### Validations for Start and End dates are not present due to time constraints 
#### Notification Engine to send notifications to developer is assumed
#### Approval workflow is not present in this example but preferred
#### Audit/Reporting is not present in this example but preferred
##### Metrics such as 
###### 'environment usage %': To gauge efficiency and scale accordingly - seasonal maybe
###### 'developer %',: Particular team testing more than others - possibly give them their own env
###### 'microservice usage %', : Particular service with big backlog - possibly give them their own env
###### 'waitlist %' : How long users have to wait - again for scalability
#### Language used is Java 8
#### There is a List in DAO that acts as a DB for this exercise
 
## TO-BE Rules for Claim
### 1. One user cannot claim more than one environment
### 2. Future claims are possible but only 1 sprint in advance
### 3. User cannot claim more than X days
### 4. Approvals are needed for reserving an environment through an approval workflow
### 5. Emails to be sent when claim is created, approved, canceled and 1 day before end date
### 6. Each microservice should have a release branch (developers working on multiple features in same codebase should merge before moving to staging)
### 7. Event driven architecture with use of Kafka queues, No SQL DB for Reads and Relational DB for persistence
### 8. Priority allocation through a waitlist for urgent production issues or reserving few environments for production issues only
### 9. Analytics of usage to be reported for scalability reasons
  

## Run Application  
### 1. Clone the repository
### 2. Run 'mvn clean install' from project root directory
### 3. From root directory run the command, 'java -jar ./target/staging-env-0.1.0.jar'

