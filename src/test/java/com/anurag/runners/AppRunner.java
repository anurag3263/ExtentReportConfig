package com.anurag.runners;

import org.testng.annotations.AfterSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import plugIn.JvmReportingPlugin;

	@CucumberOptions(
			features= "src/test/resources/Features",
			glue = {"stepDefinition"},
			dryRun = false,
			tags = "@facebook",
			monochrome = true,
			publish = true ,
			plugin = {"pretty"
					, "html:target/site/cucumber-pretty" , "json:target/Results/cucumber.json"
					, "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					, "rerun:target/rerun.txt"
			}
			)
	     
			

	public class AppRunner extends AbstractTestNGCucumberTests{
		@AfterSuite         
		  public static void generateReport() throws Throwable {
			JvmReportingPlugin.generateJVMReport();
		}
	}

