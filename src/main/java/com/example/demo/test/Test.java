package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String[] table = {"id",
                "game_id",
                "player_id",
                "single_amount",
                "profit_amount",
                "is_profit_loss",
                "payout_time",
                "effective_trade_amount",
                "contribution_amount",
                "api_id",
                "order_state",
                "game_type",
                "currency_code",
                "api_type_id",
                "account",
                "bet_id",
                "winning_amount",
                "winning_flag",
                "winning_time",
                "bet_time",
                "bet_detail",
                "username",
                "agentid",
                "agentusername",
                "topagentid",
                "topagentusername",
                "terminal",
                "stat_time",
                "grad_code",
                "grad_alias"};

        String mapper = "<id column=\"id\" property=\"id\"/>\n" +
        "        <result column=\"game_id\" property=\"gameId\"/>\n" +
        "        <result column=\"player_id\" property=\"playerId\"/>\n" +
        "        <result column=\"single_amount\" property=\"singleAmount\"/>\n" +
        "        <result column=\"profit_amount\" property=\"profitAmount\"/>\n" +
        "        <result column=\"is_profit_loss\" property=\"isProfitLoss\"/>\n" +
        "        <result column=\"payout_time\" property=\"payoutTime\"/>\n" +
        "        <result column=\"effective_trade_amount\" property=\"effectiveTradeAmount\"/>\n" +
        "        <result column=\"api_id\" property=\"apiId\"/>\n" +
        "        <result column=\"order_state\" property=\"orderState\"/>\n" +
        "        <result column=\"game_type\" property=\"gameType\"/>\n" +
        "        <result column=\"currency_code\" property=\"currencyCode\"/>\n" +
        "        <result column=\"api_type_id\" property=\"apiTypeId\"/>\n" +
        "        <result column=\"account\" property=\"account\"/>\n" +
        "        <result column=\"bet_id\" property=\"betId\"/>\n" +
        "        <result column=\"winning_amount\" property=\"winningAmount\"/>\n" +
        "        <result column=\"winning_flag\" property=\"winningFlag\"/>\n" +
        "        <result column=\"winning_time\" property=\"winningTime\"/>\n" +
        "        <result column=\"bet_time\" property=\"betTime\"/>\n" +
        "        <result column=\"username\" property=\"username\"/>\n" +
        "        <result column=\"agentid\" property=\"agentid\"/>\n" +
        "        <result column=\"agentusername\" property=\"agentusername\"/>\n" +
        "        <result column=\"topagentid\" property=\"topagentid\"/>\n" +
        "        <result column=\"topagentusername\" property=\"topagentusername\"/>\n" +
        "        <result column=\"bet_detail\" property=\"betDetail\"/>\n" +
        "        <result column=\"terminal\" property=\"terminal\"/>\n" +
        "        <result column=\"contribution_amount\" property=\"contributionAmount\"/>\n" +
        "        <result column=\"stat_time\" property=\"statTime\"/>\n" +
        "        <result column=\"grad_code\" property=\"gradCode\"/>\n" +
        "        <result column=\"grad_alias\" property=\"gradAlias\"/>";

        for(String element : table){
            //!mapper.contains(element)
            //mapper.indexOf(element)< 0
            if (!mapper.contains(element)) {
                System.out.println(element);
            }
        }


    }
    }
