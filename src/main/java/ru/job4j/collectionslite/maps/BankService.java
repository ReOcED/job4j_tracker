package ru.job4j.collectionslite.maps;

import java.util.*;

public class BankService {


    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        Optional<User> u = this.findByPassport(passport);
        if (u.isPresent()) {
            List<Account> accs = this.users.get(u.get());
            if (accs != null && !accs.contains(account)) {
                accs.add(account);
            }
        }
    }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();

    }

    public Account findByRequisite(String passport, String requisite) {
        return this.findByPassport(passport)
                .flatMap(user -> this.users.get(user).stream()
                .filter(acc -> acc.getRequisite().equals(requisite))
                .findFirst()).orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = this.findByRequisite(srcPassport, srcRequisite);
        Account dest = this.findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
            src.setBalance(src.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
