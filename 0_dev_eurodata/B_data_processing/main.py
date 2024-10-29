import subprocess

# Define the path to the Python script you want to 

def run_sub_precess(task_path,task_name):
    try:
        subprocess.run(["python", task_path], check=True)
        
        print(f"> {task_name} executed successfully !")
        
    except subprocess.CalledProcessError as e:
        print(f"> {task_name}  failed error code : {e.returncode}")


converter_script = "C:/Users/datamanager1/0_dev_eurodata/B_data_processing/script/converter.py"
cds_script = "C:/Users/datamanager1/0_dev_eurodata/B_data_processing/script/cds.py"

run_sub_precess(converter_script,'excel conversion')
run_sub_precess(cds_script,'CDS prevalidation')