namespace TestSuite2
{
    [TestClass]
    public class TestCases2
    {
        [TestMethod]
        public void FailingTest() {
            Console.WriteLine("##teamcity[testIgnored name='FailingTest' message='Ignored from Service Message']");
            Assert.AreEqual(1, 0, "This test always fails");
        }
    }
}
