# xlsx 2007 not supported natively by TOS (talend o.. S..)

# setup login and pswd in "cedentials.py"
login_str = [YOUR_LOGIN]
password_str = [YOUR_PASSWORD]

# setup download directory in main.py > Browser class > init 

# dependancy :
selenium v.


# Backing up your Selenium and WebDriver packages is a good practice to ensure you can easily restore your environment to a known working state if something goes wrong during an upgrade or due to other reasons. Here's how you can backup your packages:

Create a Virtual Environment (Optional but Recommended): Before proceeding, it's a good idea to create a virtual environment for your project. This isolates your project's dependencies from your system-wide Python installation. You can use the venv module (Python 3.3+) or virtualenv to create a virtual environment.

For example, using venv:

bash $ python3 -m venv myenv
source myenv/bin/activate  # On Windows, use: myenv\Scripts\activate
Export Package List: Once you have your virtual environment set up (or if you're working with the global Python environment), you can export a list of installed packages along with their versions to a text file using the pip freeze command:

$ pip freeze > requirements.txt
This will create a file named requirements.txt in your current directory containing a list of packages and their versions.

Backup WebDriver Executables: If you're using WebDriver (e.g., ChromeDriver, GeckoDriver), make sure to back up the WebDriver executable files as well. These files are separate from Python packages and are used to interact with browsers. You can simply copy the WebDriver executables to a safe location.

Store Backups: Store the requirements.txt file and the WebDriver executables in a safe and easily accessible location. This could be a separate directory, cloud storage, or a version control repository (e.g., Git).

When you need to restore your environment or set it up on another machine, you can follow these steps:

Create/Activate Virtual Environment (Optional): If you're using a virtual environment, create and activate it using the same steps as mentioned earlier.

Install Packages: Install the packages listed in the requirements.txt file using the following command:
$ pip install -r requirements.txt

By following these steps, you can easily recreate your Selenium and WebDriver environment along with their dependencies, which helps maintain consistency and reproducibility in your automation projects.