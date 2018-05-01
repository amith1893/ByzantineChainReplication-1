
import random
bank_acc_nums = [random.randint(0,100) for i in range(101)]
actions = ["deposit", "withdraw", "transfer"]




for num in [5000,10000,15000]:
    num_transactions = num
    s = "command_"+str(num)+".txt"
    f = open(s, 'w')
    for b in bank_acc_nums:
        s = "create amith " + str(b) + "\n"
        f.write(s)


    for i in range(0, num_transactions):
        r = random.randint(0,2)
        if actions[r] == 'deposit':
            r1 = random.randint(0,100)
            r2 = random.randint(0,1000000)
            s = 'deposit ' + str(bank_acc_nums[r1]) + " " + str(r2) + "\n"
            f.write(s)
        elif actions[r] == 'withdraw':
            r1 = random.randint(0,100)
            r2 = random.randint(0,1000000)
            s = 'withdraw ' + str(bank_acc_nums[r1]) + " " + str(r2) + "\n"
            f.write(s)
        elif actions[r] == 'transfer':
            r0 = random.randint(0,100)
            r1 = random.randint(0,100)
            r2 = random.randint(0,1000000)
            s = "transfer " + str(bank_acc_nums[r0]) + " " + str(bank_acc_nums[r1]) + " " + str(r2) + "\n"
            f.write(s)


    f.close() 
