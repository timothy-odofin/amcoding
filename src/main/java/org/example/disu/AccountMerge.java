package org.example.disu;

import java.util.*;
/**
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
 * * and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is
 * * some common email to both accounts. Note that even if two accounts have the same name,
 * * they may belong to different people as people could have the same name. A person can have any number of accounts initially,
 * * but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name,
 * * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 * * * */
public class AccountMerge {
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();

    private void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);

        if (!adjacent.containsKey(email)) {
            return;
        }

        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        int accountListSize = accountList.size();

        for (List<String> account : accountList) {
            int accountSize = account.size();

            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            String accountFirstEmail = account.get(1);
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);

                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<String>());
                }
                adjacent.get(accountFirstEmail).add(accountEmail);

                if (!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }

        // Traverse over all th accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);

                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }

        return mergedAccounts;
    }
}

/**
 * Here NNN is the number of accounts and KKK is the maximum length of an account.
 *
 *     Time complexity: O(NKlog⁡NK)
 *
 *     In the worst case, all the emails will end up belonging to a single person. The total number of emails will be N*K, and we need to sort these emails.
 *     *     DFS traversal will take NK operations as no email will be traversed more than once.
 *
 *     Space complexity: O(NK)
 *
 *     Building the adjacency list will take O(NK) space. In the end,
 *     *     visited will contain all of the emails hence it will use O(NK) space. Also, the call stack for DFS will use O(NK)O(NK)O(NK) space in the worst case.
 * * * */
