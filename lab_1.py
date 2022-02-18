print("Welcome to the Python Voter Registration Application")

Flag = str(input("\nDo you want to continue with Voter Registration? (Y/N): "))

if(Flag=='Y' or Flag=='y'):

  First = str(input("What is your first name: "))

  Flag = str(input("\nDo you want to continue with Voter Registration? (Y/N): "))

  if(Flag=='Y' or Flag=='y'):

   Last = str(input("What is your last name: "))

   Flag = str(input("\nDo you want to continue with Voter Registration? (Y/N): "))

   if(Flag=='Y' or Flag=='y'):

     Age = int(input("What is your Age: "))

     if (Age < 18):

         Flag = ' n'

     else:

      Flag = str(input("\nDo you want to continue with Voter Registration? (Y/N): "))

      if(Flag=='Y' or Flag=='y'):

       US = str(input("Are you US citizen? (Y/N)"))

       Flag = str(input("\nDo you want to continue with Voter Registration? (Y/N): "))

       if(Flag=='Y' or Flag=='y'):

         State = str(input("What state do you live? "))

         Flag = str(input("\nDo you want to continue with Voter Registration? (Y/N): "))

         if(Flag=='Y' or Flag=='y'):

          Zip = str(input("Enter your zip code: "))

          print("\nThanks for registering to vote. Here are the information we received.")

          print("\nName (first, last): %s %s"%(First,Last))

          print("Age: %d"%Age)

          if(US=='Y' or US=='y'): print("U.S. Citizen: YES")

          else:          print("U.S. Citizen: NO")

          print("State: %s"%State)

          print("Sip Code: %s"%Zip)

          print("\nThanks for trying the Voter Registration Application.")

          print("Your Voter Registration Card should be shipped within 3 weeks.")