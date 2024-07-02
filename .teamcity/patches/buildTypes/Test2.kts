package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.DotnetTestStep
import jetbrains.buildServer.configs.kotlin.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Test2'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Test2")) {
    expectSteps {
        dotnetTest {
            id = "dotnet"
            projects = "TestSuite2/TestSuite2.csproj"
            sdk = "8"
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%"
            }
        }
    }
    steps {
        update<DotnetTestStep>(0) {
            executionMode = BuildStep.ExecutionMode.RUN_ON_FAILURE
            clearConditions()
        }
        insert(1) {
            script {
                name = "Disk prep"
                id = "simpleRunner"
                scriptContent = "test"
            }
        }
    }
}
