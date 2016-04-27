package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;
        while(true)
        {
            String s = ConsoleHelper.readString();
            try
            {
                sum = Integer.parseInt(s);
            } catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage("specify.amount");
                continue;
            }
            if (sum <= 0)
            {
                ConsoleHelper.writeMessage("specify.not.empty.amount");
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(sum))
            {
                ConsoleHelper.writeMessage("not.enough.money");
                continue;
            }
            try
            {
                currencyManipulator.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("exact.amount.not.available");
                continue;
            }
            ConsoleHelper.writeMessage(String.format("success.format", sum, currencyCode));
            break;
        }
    }
}
