/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Osamu
 */
public class ActionHandling {
    static int MAX_EVENT;
    static int MAX_MULTIev;
    static List<PlyActions> actionList=new ArrayList();
    static List<plyEvents> eventList = new ArrayList();
    static List<MultiChoiceEvents> multiEventList=new ArrayList();
    static List<MultiChoiceEvents> multiEventImpl=new ArrayList();
    static  int[] lblenable = new int[20];
    static  int[] lblrevenue = new int[20];
    static int actioncontor=0;
   
static public void createActionList(){
 PlyActions pa1 = new PlyActions(0, "New Product Development", 20, 20000, 2000, 52, 20, 10, "New Product Development", "The cost of this action is 20,000$, implementation takes 20 weeks and bring 2,000$/week till the end of the level. Other benefits: Reputation: +10, Motivation: +10.", false, false, 52,20); 
 PlyActions pa2 = new PlyActions(1, "Improve Products", 8, 4200, 400, 16, 5, 3, "Improve Products", "This action costs 4,200$, implementation takes 8 weeks and revenue/week is 400$ for 16 weeks after implementation is finalized. Other benefits: Reputation: +5, Motivation: +3.", false, false, 16,8); 
 PlyActions pa3 = new PlyActions(2, "Cost Reduction", 12, 6000, 300, 52, 3, 2, "Cost Reduction", "This action costs 6000$, implementation takes 12 weeks and revenue/week is 300$ after implementation is finalized till the end of the level. Other benefits: Reputation:+3, Motivation:+2.", false, false,52,12); 
actionList.add(pa1);
actionList.add(pa2);
actionList.add(pa3);

 PlyActions pa4 = new PlyActions(3, "Teambuilding", 2, 600, 200, 4, 2, 5, "Teambuilding", "This action costs 600$, implementation after one week and revenue is 200$/week for 4 weeks after implementation is finalized. Other benefits: Reputation: +2, Motivation: +5.", false, false,4,2); 
 PlyActions pa5 = new PlyActions(4, "Bonus", 2, 800, 250, 4, 1, 5, "Bonus", "This action costs 800$, implementation takes 2 weeks and revenue/week is 250$ during 4 weeks after implementation is finalized. Other benefits: Reputation: +1, Motivation: +5.", true, false,4,2); 
 PlyActions pa6 = new PlyActions(5, "Training", 4, 2600, 400, 8, 5, 8, "Training", "This action costs 2,600$, implementation takes 4 weeks and revenue/week is 400$ for 8 weeks after implementation is finalized. Other benefits: Reputation:+5, Motivation:+8.", false, false, 8,4); 

actionList.add(pa4);
actionList.add(pa5);
actionList.add(pa6);

 PlyActions pa7 = new PlyActions(6, "TV Spot", 4, 6000, 2000, 4, 9, 5, "TV Spot", "This action costs 6,000$, implementation takes 4 weeks and revenue/week is 2000$ during 4 weeks after implementation is finalized. Other benefits: Reputation: +9, Motivation: +5.", false, false, 4,4); 
 PlyActions pa8 = new PlyActions(7, "Magazine Insert", 1, 500, 300, 2, 2, 1, "Magazine insert", "This action costs 500$, implementation takes 1 week and revenue/week is 300$ for 2 weeks after implementation is finalized. Other benefits: Reputation: +2, Motivation: +1.", false, false,2,1); 
 PlyActions pa9 = new PlyActions(8, "Change Desing", 4, 3200, 1800, 3, 6, 4, "Change Design", "This action costs 3,200$, implementation takes 4 week and revenue/week is 1800$ for 3 weeks after implementation is finalized. Other benefits: Reputation: +6, Motivation:+4.", false, false,3,4); 
 PlyActions pa10 = new PlyActions(9, "Online", 2, 1000, 1125, 1, 2, 1, "Promote Online", "This action costs 1000$, implementation takes 2 weeks and revenue/week is 1150$  after implementation is finalized. Other benefits: Reputation: +2, Motivation: +1.", false, false, 1,2); 
actionList.add(pa7);
actionList.add(pa8);
actionList.add(pa9);
actionList.add(pa10);

 PlyActions pa11 = new PlyActions(10, "Software", 14, 18000, 800, 27, 8, 14, "Software Implementation", "This action costs 18,000$, implementation takes 14 weeks and revenue/week is 800$ for 30 weeks after implementation is finalized. Other benefits: Reputation: +8, Motivation: +14.", false, false,27,14); 
actionList.add(pa11);

if(CurrentPlayer.ply.getTurns()==0){
    Arrays.fill(lblenable, -1);
    Arrays.fill(lblrevenue, -1);
}
}

static public void applyAction(int actionno){
    PlyActions pa= new PlyActions(actionList.get(actionno).getNcrt(),actionList.get(actionno).getActionName(),actionList.get(actionno).getTurnsTake(),actionList.get(actionno).getCost(),actionList.get(actionno).getWeeklyRevenue(),actionList.get(actionno).getRevenueWks(),actionList.get(actionno).getIncreaseCredibility(),actionList.get(actionno).getIncreaseMotivation(),actionList.get(actionno).getMessageHeader(),actionList.get(actionno).getMessageBody(),actionList.get(actionno).isMultiple(),actionList.get(actionno).isIsActive(),actionList.get(actionno).getWksMartor(), actionList.get(actionno).getTksMartor());
    actionList.get(actionno);
    pa.setIsActive(true);
 //  pa.setRevenueWks(pa.getWksMartor());
 //   pa.setTurnsTake(pa.getTksMartor());
     ActionUnderImpl pui = new ActionUnderImpl(actioncontor+1, pa);

     CurrentPlayer.PlyactionList.add(pui);
    lblenable[actionList.get(actionno).getNcrt()]=pa.getTksMartor(); 
    
     CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()-pa.getCost());
     pa=null;
     pui=null;
     actioncontor++;
}


public static void addWeek(){
 CurrentPlayer.ply.setTurns(CurrentPlayer.ply.getTurns()+1);
        
     for(int i=0; i<CurrentPlayer.PlyactionList.size();i++){
        PlyActions pla1 = CurrentPlayer.PlyactionList.get(i).getPla();    

            pla1.setTurnsTake(pla1.getTurnsTake()-1);
             System.out.println("1.Index:"+i+" Actiunea"+pla1.getActionName()+"SaptImpl="+pla1.getTurnsTake());
            lblenable[pla1.getNcrt()]-=1;
        
             if(pla1.getTurnsTake()==-1){
             pla1.setRevenueWks(pla1.getWksMartor());       
             CurrentPlayer.PlyImplAList.add(new ActionImpl(actioncontor, new PlyActions(pla1.getNcrt(),pla1.getActionName(),pla1.getTurnsTake(),pla1.getCost(),pla1.getWeeklyRevenue(),pla1.getRevenueWks(),pla1.getIncreaseCredibility(),pla1.getIncreaseMotivation(),pla1.getMessageHeader(),pla1.getMessageBody(),pla1.isMultiple(),pla1.isIsActive(),pla1.getWksMartor(), pla1.getTksMartor()))); 
           //  lblrevenue[pla.getNcrt()]+=pla.getWksMartor();
             CurrentPlayer.PlyactionList.remove(i);          
           //  lblenable[pla.getNcrt()]-=1;
             
             }
         pla1=null;
    }
 
          for(int i=0; i<CurrentPlayer.PlyImplAList.size();i++){
          PlyActions pla2 = CurrentPlayer.PlyImplAList.get(i).getPai();      
          System.out.println("2.Index:"+i+" Actiunea"+pla2.getActionName()+"TurnsWin="+pla2.getRevenueWks());
        if(pla2.getRevenueWks()>-1){
           // System.out.println("revenue="+CurrentPlayer.PlyactionList.get(i).getRevenueWks()+" martor="+CurrentPlayer.PlyactionList.get(i).getWksMartor());
            if(pla2.getRevenueWks()==pla2.getWksMartor()){
               CurrentPlayer.ply.setPeople(pla2.getIncreaseMotivation()+CurrentPlayer.ply.getPeople());
               CurrentPlayer.ply.setCredibility(pla2.getIncreaseCredibility()+CurrentPlayer.ply.getCredibility());              
             //  pla2.setRevenueWks(pla2.getRevenueWks()-1);
               CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+pla2.getWeeklyRevenue());
               pla2.setRevenueWks(pla2.getRevenueWks()-1);
               lblrevenue[pla2.getNcrt()]=pla2.getRevenueWks();
      
            }else{       
               CurrentPlayer.ply.setFinance(CurrentPlayer.ply.getFinance()+pla2.getWeeklyRevenue());
                pla2.setRevenueWks(pla2.getRevenueWks()-1);  
                lblrevenue[pla2.getNcrt()]=pla2.getRevenueWks();
            }
        } else{
           //lblrevenue[pla2.getNcrt()]=-1;
            CurrentPlayer.PlyImplAList.remove(i);
           
        }   
        pla2=null;
        }  


   
       
    
     
}
static public void createEvList(){
 plyEvents ev0 = new plyEvents(0, "Clients", false,"You have a quality complain from a customer. Finance: -1000$, Reputation:-8, Motivation: -2.",-1000, -8, -2);
 plyEvents ev1 = new plyEvents(0, "Competitors", false,"Your major competitor implemented a TV Spot that afect your sales. Finance: -4000$, Reputation: -3, Motivation: -9.",-4000, -3, -9);
 plyEvents ev2 = new plyEvents(0, "Competitors", false,"A competitor is succesful with a new product. Finance: -1000$, Reputation: -5, Motivation: -3", -1000, -5, -3);
 plyEvents ev3 = new plyEvents(0, "Supplier", true,"The producer lowers the price, but the quality of service decreases. Finance: 500$, Reputation:-2, Motivation:-1.",+500, -2, -1);
 plyEvents ev4 = new plyEvents(0, "Partnership", true,"Partnership with another company in terms of an event. Finance: +3000$, Reputation: +7, Motivation: +6.",+3000, +7, +6);
 plyEvents ev5 = new plyEvents(0, "Free Advertising",true, "A famous person promotes your product at an important gala. Finance: +1000$, Reputation: +4, Motivation: +3.", +1000, +4, +3);
 plyEvents ev6 = new plyEvents(0, "Autorities", false,"You got a fine. Finance: -3000$, Reputation: -1, Motivation: -1.",-3000, -1, -1);
 plyEvents ev7 = new plyEvents(0, "Products", false,"The sales of the main product dropped down. Finance: -3000, Reputation: -5, Motivation: -13.",-3000, -5, -13);
 plyEvents ev8 = new plyEvents(0, "Clients", true,"You win an auction. Finance: +1500$, Reputation: +1, Motivation: +2.",+1500, +1, +2);
 plyEvents ev9 = new plyEvents(0, "Clients", false,"You lost an auction. Finance: -1500$, Reputation: -1, Motivation: -2.",-1500, -1, -2);
 plyEvents ev10= new plyEvents(0, "Authorities",false,"After an investigation  you have to pay penalties because you miscalculate some taxes. Finance: -3000$, Reputation: -5, Motivation: -5.",-3000,-5,-5);
 plyEvents ev11= new plyEvents(0, "Products",true,"A famous magazine has chosen you to be the most innovative in terms of products. Finance: +100$, Reputation: +5, Motivation: +3.",+100,+5,+3);
 plyEvents ev12= new plyEvents(0, "Human Error",false,"You've lost some accounting papers, you have to make new ones. Finance: -1500$, Reputation: -0, Motivation: -2.",-1500,0,-2);
 plyEvents ev13= new plyEvents(0, "Clients",false,"Boicot alert!!! You tested one of your products on animals. Finance: -600$, Reputation: -4, Motivation: -1.",-600,-4,-1);
 plyEvents ev14= new plyEvents(0, "Clients",false,"Considering delivery delays, one of the retailers delisted your products. Finance: -3000$, Reputation: -5, Motivation: -5.",-3000,-5,-5);
 plyEvents ev15= new plyEvents(0, "Autorities",false,"You paid your taxes late, therefore the authorities fined you. Finance: -1500$, Reputation: -1, Motivation: -2.",-1500,-1,-2);
 plyEvents ev16= new plyEvents(0, "Human Error",false,"One of your employees has wrongly calculated the sale prices, making you lose a contract. Finance: -2000$, Reputation: -8, Motivation:-5.",-2000,-8,-5);
 plyEvents ev17= new plyEvents(0, "Clients", false, "One of your servers crushed. You need to replace it and restore the data, that caused some chaos in your deliveries. Finance: -1000$, Reputation: -3, Motivation: -2", -1000, -3, -2);
 plyEvents ev18= new plyEvents(0, "Clients", true, "You made a good job with your last delivery. Your clients are excited about your work. Finance: +2000$, Reputation: +6, Motivation: +5.", +2000, +6, +5);
 plyEvents ev19= new plyEvents(0, "Employees", true, "Your employees have done a good work this week. Finance: +800$, Reputation: +3, Motivation: +4.", +800, +3, +4);
 plyEvents ev20= new plyEvents(0, "Products", true, "Some investors are attracted to your products, you begun  some collaborations  that will benefit you. Finance: +2000, Reputation: +3, Motivation:+4.", +2000, +3, +4);
 plyEvents ev21= new plyEvents(0, "Free Advertising", true, "Some sponsors have offered to pay you money for a TV commercial. Finance: +900$, Reputation: +2, Motivation: +1.", +900, +2, +1);
 plyEvents ev22= new plyEvents(0, "Free Advertising", true, "Some sponsors have offered to pay you money for a radio commercial. Finance: +300$, Reputation: +5, Motivation: +2.", +300, +5, +2);
 plyEvents ev23= new plyEvents(0, "Lucky", true, "You received the new equipment as a gift. Credibility: +3, Motivation: +4.", +0, +3, +4);
 plyEvents ev24= new plyEvents(0, "Employees", true, "Your business accountant is becoming more and more skillful. Finance: +1000$, Reputation: +1, Motivation: +4.", +1000, +1, +4);
 plyEvents ev25= new plyEvents(0, "Lucky", true, "Netflex has given you an opportunity to develop a project together. Finance: +2000$, Reputation: +10, Motivation: +5.", +2000, +10, +5);
 plyEvents ev26= new plyEvents(0, "Free Advertising", true, "A documentary about your business has been made. Finance: +1500$, Reputation: +3, Motivation: +4.", +1500, +3, +4);
 plyEvents ev27= new plyEvents(0, "Free Advertising", true, "Micky Ninaj tweeted and said she likes your products. Finance: +3000$, Reputation: +2, Motivation: +4.", +3000, +2, +4);
 plyEvents ev28= new plyEvents(0, "Clients", false, "Micky Ninaj tweeted and said she doen't like your products. Finance: -3000$, Reputation: -2, Motivation: -4.", -3000, -2, -4);
 plyEvents ev29= new plyEvents(0, "Free Advertising", true, "Gelena Somez tweeted and said she likes your products. Finance: +2000$, Reputation: +8, Motivation: +4.", +2000, +8, +4);
 plyEvents ev30= new plyEvents(0, "Clients", false, "A TV news mentions one of your products in a bad context, your sales droped. Finance: -3000$, Reputation: -6, Motivation: -5.", -3000, -6, -5);
 plyEvents ev31= new plyEvents(0, "Free Advertising", true, "Cim Cardashian posted on Biztagram and said she likes your products. Finance: +4000$, Reputation: +2, Motivation: +4.", +4000, +2, +4);
 plyEvents ev32= new plyEvents(0, "Clients", false, "Cim Cardashian posted on Biztagram and said she doen't like your products. Finance: -4000$, Reputation: -2, Motivation: -4.", -4000, -2, -4);
 plyEvents ev33= new plyEvents(0, "Free Advertising", true, "PewPieDie posted on BizTube and said he likes your products. Finance: +4000$, Reputation: +2, Motivation: +4.", +4000, +2, +4);
 plyEvents ev34= new plyEvents(0, "Clients", false, "PewPieDie posted on Biztube and said he doen't like your products. Finance: -4000$, Reputation: -2, Motivation: -4.", -4000, -2, -4);
 eventList.add(ev0);
 eventList.add(ev1); 
 eventList.add(ev2);
 eventList.add(ev3);
 eventList.add(ev4);
 eventList.add(ev5); 
 eventList.add(ev6);
 eventList.add(ev7);
 eventList.add(ev8);
 eventList.add(ev9);
  eventList.add(ev10);
 eventList.add(ev11); 
 eventList.add(ev12);
 eventList.add(ev13);
 eventList.add(ev14);
 eventList.add(ev15); 
 eventList.add(ev16);
 eventList.add(ev17);
 eventList.add(ev18);
 eventList.add(ev19);
 eventList.add(ev20);
 eventList.add(ev21); 
 eventList.add(ev22);
 eventList.add(ev23);
 eventList.add(ev24);
 eventList.add(ev25); 
 eventList.add(ev26);
 eventList.add(ev27);
 eventList.add(ev28);
 eventList.add(ev29); 
 eventList.add(ev30); 
 eventList.add(ev31);
 eventList.add(ev32);
 eventList.add(ev33);
 eventList.add(ev34);
MAX_EVENT = eventList.size()-1;
}
static public void createMultiChoiceList(){
    plyEvents ev1 = new plyEvents(0, "Authorities", false,"A Tax Inspector control your bussines. He has found some serious irregularities and announces that you will receive a 3000$ fine ",-3000, -10, -5);
    MultiChoiceEvents mev1 = new MultiChoiceEvents(ev1, "Pay the fine","Contests the outcome of the inspection and asks for a review","You bribe the inspector and escape without the fine.", 1, "Revised inspection that you asked, ended. Unfortunately the fine has increased to 7,000$. Reputation: -20, Motivation: -15. ", -20,-15,-7000, 10,"The bribed inspector was caught while falsifying the results of a financial surveillance. He also confessed the bribe received from your company. The authorities have fined your company for $ 20,000 and you are being investigated for bribery. Finance: -2000$, Reputation: -40, Motivation: -40.",-40,-40, -20000,0,0);
    multiEventList.add(mev1);
    plyEvents ev2= new plyEvents(0,"Coruption", false,"You have the opportunity to pay $5000 to the senator to turn a blind eye so you launch your products better. what will you do?", +1000, +50, +10);
    MultiChoiceEvents mev2= new MultiChoiceEvents(ev2,"Accept","Politely refuse", "Insult him.", 1, "The senator was impressed by your integrity and lobbyed for a law that benefits you. Finance: +500, Reputation: +30, Motivation: +10", +30, +10,+500, 1,"The senator didn't forget how you treated him and initiated a law that would disadvantage you from the competition.Finance: -4000, Reputation: -60, Motivation: -30", -60, -30,-4000,0,0);
    multiEventList.add(mev2);
 //plyEvents ev1 = new plyEvents(0, "Authorities", false,"A Tax Inspector control your bussines. He has found some serious irregularities and announces that you will receive a considerable fine.",-3000, -10, -5);
    MultiChoiceEvents mev3 = new MultiChoiceEvents(ev1, "Pay the fine","Contests the outcome of the inspection and asks for a review","You bribe the inspector and escape without the fine", 1, "Revised inspection has ended, you were right to ask for a review. Reputation: +10, Motivation: +!5", 10,15,0, 1,"The bribery inspector was caught. He also confessed the bribe received from your company. The authorities have fined your company for $ 20,000 and you are being investigated. Reputation: -30, Motivation: -30.",-30,-40, -20000,0,0);
    multiEventList.add(mev3);
    plyEvents ev4=new plyEvents(0, "Software",false, "A hacker attaked your servers and got private informations that if it goes public it might affect negatively your company. What you will do?", +0,+0,+1000);
    MultiChoiceEvents mev4= new MultiChoiceEvents(ev4, "Pay 1000$ for his silence","Involve the police","Ignore",1,"Authorities made their job and find the hacker.You won a reward. Finance: +5000, Reputation: +30, Motivation: +20.", 30, 20,5000, 1,"Now your reputation is decrease. You should go to the police when you had the chance. Finance: -900, Reputation: -20, Motivation: -15.", -50, -20,-900,0,0);
    multiEventList.add(mev4); 
    plyEvents ev5=new plyEvents(0, "Competition",false, "Your competitor called you \"a thief\"/\"child labourer\" on national television. What you will do?", -50,-30,-7000);
    MultiChoiceEvents mev5= new MultiChoiceEvents(ev5, "Insult back","Make a video about this","Ignore",1,"People were impressed and many of them start to look for your products. Finance: +5000, Reputation: +30, Motivation: +20", 30, 20,5000, 1,"Your sells start to decrease. Finance: -4000, Reputation: -60, Motivation: -30.", -50, -20,-900,0,0);
    multiEventList.add(mev5);
    plyEvents ev6=new plyEvents(0,"Fans",false, "Your fans have asked you for an eveniment. What you will do?", +50,+40,-500);
    MultiChoiceEvents mev6= new MultiChoiceEvents(ev6, "You accept to pay 500$ for it","Ignore","Promise that you will make it another time",1,"You lost your reputation, now everyone thinks you are unserious. Finance: -5000, Reputation: -80.", -60, 0,-5000, 1,"Your fans wait for the event, some of them lost their trust in your company. Finance: -5000, Reputation: -30", -30, 0,-900,0,0);
     multiEventList.add(mev6);
     plyEvents ev7=new plyEvents(0, "Clients",false, "One of your clients wants to return a product because it's not what he wanted. What you will do?", +40,+10,-300);
     MultiChoiceEvents mev7= new MultiChoiceEvents(ev7, "Accept","Refuse","Try to convince him that the product is what he wanted ",1,"The client said to everyone about it. Now your clients are dissapointed. Reputation:-50, Motivation: -10, Fianance: -4000", -50, -10,-4000, 1,"The customer has been annoyed and will no longer buy from your company. Reputation: -30, Fianance: -300", -30, 0,-300,0,0);
     multiEventList.add(mev7);
     plyEvents ev8=new plyEvents(0, "Manufacturers",false, "One of your producers sues you for failing to respect certain aspects of your contract. What you will do?", +40,+30,0);
     MultiChoiceEvents mev8= new MultiChoiceEvents(ev8, "Try to reach a common agreement with the producer and promise this will never happen again ","Go to the court","You beat him.",1,"Your reputation decreses and your funds too, you didn't won the process. Reputation: -50, Motivation: -30, Fianance: -2000", -50, -30,-2000, 1,"Now you have problems with authorities. Reputation: -60, Motivation: -30, Finance: -1000", -60, -30,-1000,0,0);
     multiEventList.add(mev8);
     plyEvents ev9=new plyEvents(0, "Hackers",false, "A hacker has contacted you about secret information about your competitor and asks for 7000$ for sharing it with you. What will you do?", +0,+0,-7000);
     MultiChoiceEvents mev9= new MultiChoiceEvents(ev9, "Pay for it","Ignore","Call the police",1,"Good idea, you would lost that money for nothing.", 0, 0,0, 1,"Everyone is proud of you and your interity. Reputation: +60, Finance: +1300.", +60, 0,1300,0,0);
     multiEventList.add(mev9);
     plyEvents ev10=new plyEvents(0, "Fans",false, "A fan suggested that your brand start an online campaign. What will you do?", +30,+10,+2000);
     MultiChoiceEvents mev10= new MultiChoiceEvents(ev10, "Start the campaign","Ignore","Try to refuse in a ploite way",1,"You lost some of yours biggest fans. Finance: -5000, Reputation: -70, Motivation:-20.", -70, -20, -5000, 1,"Your fan understood you and continue to support you.", 0, 0,0,0,0);
     multiEventList.add(mev10);
     plyEvents ev11=new plyEvents(0, "InfluencerAlert",false, "An instagram thot named Victoria asked you to pay her to make a post talking about your brand. What will you do?", +30,+10,-1000);
     MultiChoiceEvents mev11= new MultiChoiceEvents(ev11, "Pay 1000$","Ignore","Make an instastory about it",1,"She made a video about your proucts and said you are fake. Reputation: -40, Finance: -800",-40, 0,-800, 1,"You won the admiration of so many people. Reputation: +40, Motivation: +30.", +40, +30,-0,0,0);
     multiEventList.add(mev11);
     plyEvents ev12=new plyEvents(0, "Luck",false, "You have the urge to play the lottery. What will you do?", +0,+0,+50000);
     MultiChoiceEvents mev12= new MultiChoiceEvents(ev12, "Don't play","Play","Play and go to the casino too",1,"You won the big price, 50000$!!!", 0, 0, 50000, 1,"You lost 60000$ at the casino...", 0, 0,-6000,0,0);
     multiEventList.add(mev12);
     plyEvents ev13=new plyEvents(0, "Luck",false, "You have the urge to play the lottery. What will you do?", +0,+0,-1000);
     MultiChoiceEvents mev13= new MultiChoiceEvents(ev13, "Don't play","Play","Play and go to the casino too",1,"You lost 1000$.", 0, 0, -1000, 1,"You won the big Jackpot!!! Finance: +50000", 0, 0,+50000,0,0);
     multiEventList.add(mev13);
     plyEvents ev14=new plyEvents(0, "Employees",false, "You are being sued for terminating an employment without a reason. Which law firm will you choose to represent you in court?", +0,+0,-4000);
     MultiChoiceEvents mev14= new MultiChoiceEvents(ev14, "Bribe the judge, and lose -400000$","Osamu and associates, price: $5000","Soft and studios, price: $2000 ",1,"You won the process!!! Finance: +5000, Reputation: +30", 30, 0,5000, 1,"You lost the process. Finance:-5000, Reputation: -60", -60, 0,-5000,0,0);
     multiEventList.add(mev14);
     plyEvents ev15=new plyEvents(0, "Competitors",false, "You have discovered the strategy of a competitor of yours. What will you do?", +0,+0,+0);
     MultiChoiceEvents mev15= new MultiChoiceEvents(ev15, "Continue normal","Try to be with one step ahead of every move he has","Copy him",1,"Good idea!!! Finance: +1000, Reputation: +20, Motivation: +10", 20, 10,1000, 1,"Bad idea, everyone thinks you are not original. Finance: -500, Reputation: -30", -30, 0,-500,0,0);
     multiEventList.add(mev15);
     plyEvents ev16=new plyEvents(0, "Free Advertising",false, "It happened that Ciley Myrus loves your products and asked for a collaboration. What will you do?", +10,+10,+1000);
     MultiChoiceEvents mev16= new MultiChoiceEvents(ev16, "Do it!!!","Call her manager and negociate","Don't do it",1,"Good idea, now this colaboration gives you 4000$. Reputation: +30", 30, 0,4000, 1,"You lost a great chance and now Ciley's fans don't like your products. Reputation: -30, Finance: -950$.", -30, 0,-950,0,0);
     multiEventList.add(mev16);
     plyEvents ev17=new plyEvents(0, "Employees",false, "Your employees have made you a surprise for your birthday, but you're not exactly in a good mood, how are you reacting?", 0,60,0);
     MultiChoiceEvents mev17= new MultiChoiceEvents(ev17, "Try to look happy and do not ruin their day","You tell them you do not have the right condition for a party","You put them to work and give them extra hours to recover lost time",1,"Your employees try tu undestand you and let you relax.", 0, 0, 0, 1,"Your emplyees are angry, they are not working as better as they usually do. Reputation: -50", -50, 0, 0,0,0);
     multiEventList.add(mev17);
     plyEvents ev18=new plyEvents(0, "Free Advertising",false, "Cames Jharles want to promote your business and asks for $1000. what will you do?", +0,+0,-6000);
     MultiChoiceEvents mev18= new MultiChoiceEvents(ev18, "Yes","No","Insult him",1,"Good idea,he is not a person you can put your trust in.", 0, 0,0, 1,"He made a video about it, now his fans hate you, haha joking, he has no fans.", 0, 0,0,0,0);
     multiEventList.add(mev18);
     plyEvents ev19=new plyEvents(0, "Competitions",false, "You and your competitor are publicly arguing about who makes more money. what will you do?", +20,+0,+100);
     MultiChoiceEvents mev19= new MultiChoiceEvents(ev19, "Apologize to him","Argue with him","Take him to the court",1,"Your reputation decreases. Finance: -600, Reputation: -20.", -20, 0,-600, 1,"You lost the process. Finance: -400, Reputation: -40.", -40,0,-400,0,0);
     multiEventList.add(mev19);
     plyEvents ev20=new plyEvents(0, "Oportunity",false, "Tintnedo has offered to make a video game about your business. Will you accept the offer?", +20,+0,+5000);
     MultiChoiceEvents mev20= new MultiChoiceEvents(ev20, "Accept","Politely refuse","Make a survey on intagram and let people decide for you",1,"You start to have a very basic company, you should be more opened to new ideas. Finance: -800, Reputation: -20.", 30, 20,5000, 1,"Your followers said you should accept it! Finance: +1000, Reputation: +20", +20, 0,+1000,0,0);
     multiEventList.add(mev20);
    MAX_MULTIev = multiEventList.size()-1;
}


 

 
}
