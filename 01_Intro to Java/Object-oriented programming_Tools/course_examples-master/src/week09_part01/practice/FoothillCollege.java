package week09_part01.practice;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Example class with numeric data series based on Foothill College facts:
 * https://foothill.edu/news/fh-facts.php
 * http://research.fhda.edu/_downloads/FH%20Headcount%20by%20Term%20-%2001.12.17.pdf
 * @author Foothill College, Bita M.
 */
public class FoothillCollege
{
    private final int OPENING_YEAR = 1957;
    private int currentYear;

    private ArrayList<EnrollmentYear> enrollmentHistory;

    public class EnrollmentYear
    {
        private int year;
        private int enrollment;

        public EnrollmentYear(int year, int enrollment)
        {
            this.year = year;
            this.enrollment = enrollment;
            currentYear = LocalDate.now().getYear();
        }

        public void setYear(int year)
        {
            if (year < OPENING_YEAR && year > currentYear)
            {
                this.year = OPENING_YEAR;
                return;
            }
            this.year = year;
        }

        public void setEnrollment(int enrollment)
        {
            if (enrollment < 0)
            {
                this.enrollment = 0;
                return;
            }
            this.enrollment = enrollment;
        }

        public int getYear()
        {   return this.year; }

        public int getEnrollment()
        {   return enrollment; }
    }

    public FoothillCollege()
    {
        enrollmentHistory = new ArrayList<>();
        enrollmentHistory.add(new EnrollmentYear(1957, 17474));
        enrollmentHistory.add(new EnrollmentYear(1991, 12080+20029+19424+16982));
        enrollmentHistory.add(new EnrollmentYear(1992, 10859+17439+16572+15005));

        enrollmentHistory.add(new EnrollmentYear(1993, 11103+15221+13511+13101));
        enrollmentHistory.add(new EnrollmentYear(1994, 11428+13752+12885+13855));
        enrollmentHistory.add(new EnrollmentYear(1995, 8337+13107+12103+10862));
        enrollmentHistory.add(new EnrollmentYear(1996, 8133+12605+12903+12515));
        enrollmentHistory.add(new EnrollmentYear(1997, 9576+14291+14161+12831));
        enrollmentHistory.add(new EnrollmentYear(1998, 9941+15178+14153+12592));
        enrollmentHistory.add(new EnrollmentYear(1999, 10448+16018+14906+12887));
        enrollmentHistory.add(new EnrollmentYear(2000, 11386+16675+15248+13241));
        enrollmentHistory.add(new EnrollmentYear(2001, 11542+17883+16252+13934));
        enrollmentHistory.add(new EnrollmentYear(2002, 11883+18804+17890+15712));
        enrollmentHistory.add(new EnrollmentYear(2003, 13380+19365+17727+15082));
        enrollmentHistory.add(new EnrollmentYear(2004, 11622+18326+16337+14178));
        enrollmentHistory.add(new EnrollmentYear(2005, 11008+17406+16702+14231));
        enrollmentHistory.add(new EnrollmentYear(2006, 10816+17677+16362+14761));
        enrollmentHistory.add(new EnrollmentYear(2007, 10671+18342+16313+14478));
        enrollmentHistory.add(new EnrollmentYear(2008, 11145+18522+16710+15230));
        enrollmentHistory.add(new EnrollmentYear(2009, 11890+19107+17833+14253));
        enrollmentHistory.add(new EnrollmentYear(2010, 13646+18086+15406+14183));
        enrollmentHistory.add(new EnrollmentYear(2011, 0+16898+14584+14307));
        enrollmentHistory.add(new EnrollmentYear(2012, 0+15500+13726+13320));
        enrollmentHistory.add(new EnrollmentYear(2013, 0+14228+12894+13106));
        enrollmentHistory.add(new EnrollmentYear(2014, 0+13347+12931+12279));
        enrollmentHistory.add(new EnrollmentYear(2015, 0+13277+12322+12153));
        enrollmentHistory.add(new EnrollmentYear(2016, 0+13528+12385+12766));
    }

    public ArrayList<EnrollmentYear> getEnrollmentHistory()
    {   return enrollmentHistory; }
}
