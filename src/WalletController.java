public static String vievWallet(){
  Wallet wallet = Student.getWallet();
  String walletInfo;

  walletInfo = String.format("You have %s coolcoins available.\nYour bought artifacts: %s", wallet.balance, wallet.artifacts);

  return walletInfo;
}
