import java.util.Date;
public class Terminal{
    public static void main(String[]args){
        
        Date date = new Date();
        Owner o = new Owner("Palle", "65");
        Customer customer1 = new Customer("Rasmus","Pallesen",12345678,true);
        CreditCard creditcard1 = new CreditCard("abc123", 5000);
        WashCard washcard1 = new WashCard("123abc", 0, 0);
        // objekter til vores statistic
        Carwash carwash1 = new Carwash("", 0);
        Carwash carwash2 = new Carwash("Goldwash", 150);
        Carwash carwash3 = new Carwash("Silverwash", 100);
        Carwash carwash4 = new Carwash("Bronzewash", 50);
        Carwash carwash5 = new Carwash("Goldwash", 150);
        Carwash carwash6 = new Carwash("Silverwash", 100);
        Carwash carwash7 = new Carwash("Bronzewash", 50);
        Carwash carwash8 = new Carwash("Goldwash", 150);
        Carwash carwash9 = new Carwash("Silverwash", 100);
        Carwash carwash10 = new Carwash("Bronzewash", 50);
        Carwash carwash11 = new Carwash("Goldwash", 150);
        Carwash carwash12 = new Carwash("Silverwash", 100);
        Carwash carwash13 = new Carwash("Bronzewash", 50);
        Carwash carwash14 = new Carwash("Goldwash", 150);
        Carwash carwash15 = new Carwash("Silverwash", 100);
        Carwash carwash16 = new Carwash("Bronzewash", 50);
        Carwash carwash17 = new Carwash("Goldwash", 150);
        Carwash carwash18 = new Carwash("Silverwash", 100);
        Carwash carwash19 = new Carwash("Bronzewash", 50);
     
        carwash1.addCarwash(carwash2);
        carwash1.addCarwash(carwash3);
        carwash1.addCarwash(carwash4);
        carwash1.addCarwash(carwash5);
        carwash1.addCarwash(carwash6);
        carwash1.addCarwash(carwash7);
        carwash1.addCarwash(carwash8);
        carwash1.addCarwash(carwash9);
        carwash1.addCarwash(carwash10);
        carwash1.addCarwash(carwash11);
        carwash1.addCarwash(carwash12);
        carwash1.addCarwash(carwash13);
        carwash1.addCarwash(carwash14);
        carwash1.addCarwash(carwash15);
        carwash1.addCarwash(carwash16);
        carwash1.addCarwash(carwash17);
        carwash1.addCarwash(carwash18);
        carwash1.addCarwash(carwash19);
        
       
       for(int i=0 ; i <1 ; ){
       
       // START MENU 
        System.out.println("");
        System.out.println("Main Menu: Choose one of the following Options");
        System.out.println("");
        System.out.println("Buy a wash card (1)");
        System.out.println("Buy Car Wash (2)");
        System.out.println("Refill Wash Card (3)");
        System.out.println("Check Wash Card Balance (4)");
        System.out.println("Owner Options (5)");
        System.out.println("Quit (6)");
       
       
       String optionChoice = System.console().readLine();

       // 1.OPTION: BUY A WASH CARD
       if(optionChoice.equals("1")){
        System.out.println("You chose Buy washcard");
        System.out.println("");
        System.out.println("choose a price for your washcard between (200-1000)");
        int washcardprice = Integer.parseInt(System.console().readLine());

            if(washcardprice >= 200 && washcardprice <= 1000){
                washcard1.setprice(washcardprice);
                System.out.println("You are about to buy a " + washcardprice + "kr washcard" );
                System.out.println("Do you want to confirm this (y/n)");
                String confirmPurchase = System.console().readLine();
                if(confirmPurchase.equals("y")){
                    creditcard1.buyWashCard(washcard1.getCardPrice());
                    System.out.println(" Do you want a Reciept? (y/n)");
                    String printReciept = System.console().readLine();
                    if(printReciept.equals("y")){
                        washcard1.printReciept("This is your reciept");
                        System.out.println(date.toString());
                        System.out.println("Have a Nice Day");
                        System.out.println("_________________");
                    }
                    else if(printReciept.equals("n")){
                        System.out.println("Have a Nice Day");
                    }
                    else{
                        System.out.println("YOU FAIL");
                    }

                }
                else if(confirmPurchase.equals("n")){
                System.out.println("canceling purchase");
                }
                else{
                    System.out.println("YOU KEEP FAILING!!! YOU FAILURE!!!!");
                }
            }
            else{
            System.out.println("invalid amount");
            }

       }
       
       // 2.OPTION: BUY A CAR WASH
       else if(optionChoice.equals("2")){
            System.out.println("You have chosen to buy a car wash");
            System.out.println("Press 1 for goldwash the price is 300kr");
            System.out.println("Press 2 for Silverwash the price is 250kr");
            System.out.println("Press 3 for Bronzewash the price is 200kr");
            String chooseWashtype = System.console().readLine();
            if(chooseWashtype.equals("1")|| chooseWashtype.equals("2")|| chooseWashtype.equals("3")){
                carwash1.setwashType(chooseWashtype);
                carwash1.setprice(carwash1.getwashtype());
                System.out.println("You have chosen " + carwash1.getwashtype());
                System.out.println("Do you wish to confirm washtype(y/n)");
                String confirmWashtype = System.console().readLine();
                    if(confirmWashtype.equals("y")){
                        washcard1.useWashcard(carwash1.getPrice());
                        System.out.print("Do you want a reciept? (y/n)");
                        String printReciept = System.console().readLine();
                            if(printReciept.equals("y")){
                                carwash1.printReciept();
                                System.out.println(date.toString());
                                System.out.println("Have a Nice Day");
                                System.out.println("_________________");
                            }
                            else if(printReciept.equals("n")){
                            System.out.println("Have a Nice Day");
                            }
                            else{
                            System.out.println("YOU FAIL");
                        }

                    }
            }

       }


       // 3.OPTION: REFILL WASHCARD
       else if(optionChoice.equals("3")){
            System.out.println("You chose to refill your Washcard");
            System.out.println("You can now deposit between 200 and 1000kr. Maximum amount on washcard is 1000kr and the minimum amount is 200kr");
            int washcardRefill = Integer.parseInt(System.console().readLine());
                if(washcardRefill >= 200 && washcardRefill <=1000){
                    System.out.println("You are about to add " + washcardRefill + "kr to your Washcard");
                    System.out.println("Do you Accept? (y/n)");
                    String confirmRefill = System.console().readLine();
                    
                        if(confirmRefill.equals("y")){
                            washcard1.refillWashcard(washcardRefill);
                            System.out.println(" Do you want a reciept? (y/n)");
                            String confirmReciept = System.console().readLine();
                                if(confirmReciept.equals("y")){
                                washcard1.printReciept("This is your reciept");
                                System.out.println(date.toString());
                                System.out.println("Have a Nice Day");
                                System.out.println("_________________");
                                }
                                else if(confirmReciept.equals("n")){
                                    System.out.println("Have a nice day");
                                }
                                else{
                                    System.out.println("you fail again");
                                }

                        }
                        else if(confirmRefill.equals("n")){
                            System.out.println("dont want refill");
                        }
                        else{
                            System.out.println("you fail");
                        }
                  
                }
                else{
                    System.out.println("added a wrong amount");
                }       
       }


       // 4.OPTION: CHECK WASHCARD BALANCE

       else if(optionChoice.equals("4")){
            System.out.println("You have chosen to check your washcard balance");
            washcard1.printReciept(" ");
            System.out.println();
            System.out.println("_________________");
       }

       // 5.OPTION OWNER CHECKS STATISTICS:

       else if(optionChoice.equals("5")){
            System.out.print("please insert your Username:");
            String userName = System.console().readLine();
            System.out.print("please insert your UserCode:");
            String userCode = System.console().readLine();
                if (userName.equals(o.getOwnername()) && userCode.equals(o.getOwnerCode())){
            carwash1.printStatistic();
                }
                else{
                    System.out.println("Either your code or username was incorrect");
                }
       }

// 6.OPTION TERMINATE:
       else if(optionChoice.equals("6")){
           i = i+1;
       }
       else{
           System.out.println("You need to choose between option 1-6 ");
       }
       }








        // carwash1.setwashType("1");
        // carwash1.setprice(carwash1.getwashtype());






    }
}