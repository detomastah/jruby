// created by jay 1.0.2 (c) 2002-2004 ats@cs.rit.edu
// skeleton Java 1.0 (c) 2002 ats@cs.rit.edu

					// line 2 "RipperParser.y"
/*
 ***** BEGIN LICENSE BLOCK *****
 * Version: EPL 2.0/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Eclipse Public
 * License Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.eclipse.org/legal/epl-v10.html
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 *
 * Copyright (C) 2013-2017 The JRuby Team (jruby@jruby.org)
 * 
 * Alternatively, the contents of this file may be used under the terms of
 * either of the GNU General Public License Version 2 or later (the "GPL"),
 * or the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the EPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the EPL, the GPL or the LGPL.
 ***** END LICENSE BLOCK *****/
package org.jruby.ext.ripper;

import org.jruby.RubyArray;
import org.jruby.lexer.LexerSource;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;
import static org.jruby.lexer.LexingCommon.EXPR_BEG;
import static org.jruby.lexer.LexingCommon.EXPR_FITEM;
import static org.jruby.lexer.LexingCommon.EXPR_FNAME;
import static org.jruby.lexer.LexingCommon.EXPR_ENDFN;
import static org.jruby.lexer.LexingCommon.EXPR_ENDARG;
import static org.jruby.lexer.LexingCommon.EXPR_END;
import static org.jruby.lexer.LexingCommon.EXPR_LABEL;

public class RipperParser extends RipperParserBase {
    public RipperParser(ThreadContext context, IRubyObject ripper, LexerSource source) {
        super(context, ripper, source);
    }
					// line 52 "-"
  // %token constants
  public static final int keyword_class = 257;
  public static final int keyword_module = 258;
  public static final int keyword_def = 259;
  public static final int keyword_undef = 260;
  public static final int keyword_begin = 261;
  public static final int keyword_rescue = 262;
  public static final int keyword_ensure = 263;
  public static final int keyword_end = 264;
  public static final int keyword_if = 265;
  public static final int keyword_unless = 266;
  public static final int keyword_then = 267;
  public static final int keyword_elsif = 268;
  public static final int keyword_else = 269;
  public static final int keyword_case = 270;
  public static final int keyword_when = 271;
  public static final int keyword_while = 272;
  public static final int keyword_until = 273;
  public static final int keyword_for = 274;
  public static final int keyword_break = 275;
  public static final int keyword_next = 276;
  public static final int keyword_redo = 277;
  public static final int keyword_retry = 278;
  public static final int keyword_in = 279;
  public static final int keyword_do = 280;
  public static final int keyword_do_cond = 281;
  public static final int keyword_do_block = 282;
  public static final int keyword_return = 283;
  public static final int keyword_yield = 284;
  public static final int keyword_super = 285;
  public static final int keyword_self = 286;
  public static final int keyword_nil = 287;
  public static final int keyword_true = 288;
  public static final int keyword_false = 289;
  public static final int keyword_and = 290;
  public static final int keyword_or = 291;
  public static final int keyword_not = 292;
  public static final int modifier_if = 293;
  public static final int modifier_unless = 294;
  public static final int modifier_while = 295;
  public static final int modifier_until = 296;
  public static final int modifier_rescue = 297;
  public static final int keyword_alias = 298;
  public static final int keyword_defined = 299;
  public static final int keyword_BEGIN = 300;
  public static final int keyword_END = 301;
  public static final int keyword__LINE__ = 302;
  public static final int keyword__FILE__ = 303;
  public static final int keyword__ENCODING__ = 304;
  public static final int keyword_do_lambda = 305;
  public static final int tIDENTIFIER = 306;
  public static final int tFID = 307;
  public static final int tGVAR = 308;
  public static final int tIVAR = 309;
  public static final int tCONSTANT = 310;
  public static final int tCVAR = 311;
  public static final int tLABEL = 312;
  public static final int tCHAR = 313;
  public static final int tUPLUS = 314;
  public static final int tUMINUS = 315;
  public static final int tUMINUS_NUM = 316;
  public static final int tPOW = 317;
  public static final int tCMP = 318;
  public static final int tEQ = 319;
  public static final int tEQQ = 320;
  public static final int tNEQ = 321;
  public static final int tGEQ = 322;
  public static final int tLEQ = 323;
  public static final int tANDOP = 324;
  public static final int tOROP = 325;
  public static final int tMATCH = 326;
  public static final int tNMATCH = 327;
  public static final int tDOT = 328;
  public static final int tDOT2 = 329;
  public static final int tDOT3 = 330;
  public static final int tAREF = 331;
  public static final int tASET = 332;
  public static final int tLSHFT = 333;
  public static final int tRSHFT = 334;
  public static final int tANDDOT = 335;
  public static final int tCOLON2 = 336;
  public static final int tCOLON3 = 337;
  public static final int tOP_ASGN = 338;
  public static final int tASSOC = 339;
  public static final int tLPAREN = 340;
  public static final int tLPAREN2 = 341;
  public static final int tRPAREN = 342;
  public static final int tLPAREN_ARG = 343;
  public static final int tLBRACK = 344;
  public static final int tRBRACK = 345;
  public static final int tLBRACE = 346;
  public static final int tLBRACE_ARG = 347;
  public static final int tSTAR = 348;
  public static final int tSTAR2 = 349;
  public static final int tAMPER = 350;
  public static final int tAMPER2 = 351;
  public static final int tTILDE = 352;
  public static final int tPERCENT = 353;
  public static final int tDIVIDE = 354;
  public static final int tPLUS = 355;
  public static final int tMINUS = 356;
  public static final int tLT = 357;
  public static final int tGT = 358;
  public static final int tPIPE = 359;
  public static final int tBANG = 360;
  public static final int tCARET = 361;
  public static final int tLCURLY = 362;
  public static final int tRCURLY = 363;
  public static final int tBACK_REF2 = 364;
  public static final int tSYMBEG = 365;
  public static final int tSTRING_BEG = 366;
  public static final int tXSTRING_BEG = 367;
  public static final int tREGEXP_BEG = 368;
  public static final int tWORDS_BEG = 369;
  public static final int tQWORDS_BEG = 370;
  public static final int tSTRING_DBEG = 371;
  public static final int tSTRING_DVAR = 372;
  public static final int tSTRING_END = 373;
  public static final int tLAMBDA = 374;
  public static final int tLAMBEG = 375;
  public static final int tNTH_REF = 376;
  public static final int tBACK_REF = 377;
  public static final int tSTRING_CONTENT = 378;
  public static final int tINTEGER = 379;
  public static final int tIMAGINARY = 380;
  public static final int tFLOAT = 381;
  public static final int tRATIONAL = 382;
  public static final int tREGEXP_END = 383;
  public static final int tIGNORED_NL = 384;
  public static final int tCOMMENT = 385;
  public static final int tEMBDOC_BEG = 386;
  public static final int tEMBDOC = 387;
  public static final int tEMBDOC_END = 388;
  public static final int tSP = 389;
  public static final int tHEREDOC_BEG = 390;
  public static final int tHEREDOC_END = 391;
  public static final int tSYMBOLS_BEG = 392;
  public static final int tQSYMBOLS_BEG = 393;
  public static final int tDSTAR = 394;
  public static final int tSTRING_DEND = 395;
  public static final int tLABEL_END = 396;
  public static final int tLOWEST = 397;
  public static final int k__END__ = 398;
  public static final int yyErrorCode = 256;

  /** number of final state.
    */
  protected static final int yyFinal = 1;

  /** parser tables.
      Order is mandated by <i>jay</i>.
    */
  protected static final short[] yyLhs = {
//yyLhs 648
    -1,   145,     0,   133,   134,   134,   134,   134,   135,   148,
   135,    37,    36,    38,    38,    38,    38,    44,   149,    44,
   150,    39,    39,    39,    39,    39,    39,    39,    39,    39,
    39,    39,    39,    39,    39,    39,    39,    39,    39,    39,
    39,    39,    39,    39,    31,    31,    40,    40,    40,    40,
    40,    40,    45,    32,    32,    59,    59,   152,   110,   140,
    43,    43,    43,    43,    43,    43,    43,    43,    43,    43,
    43,   111,   111,   122,   122,   112,   112,   112,   112,   112,
   112,   112,   112,   112,   112,    71,    71,   100,   100,   101,
   101,    72,    72,    72,    72,    72,    72,    72,    72,    72,
    72,    72,    72,    72,    72,    72,    72,    72,    72,    72,
    77,    77,    77,    77,    77,    77,    77,    77,    77,    77,
    77,    77,    77,    77,    77,    77,    77,    77,    77,     6,
     6,    30,    30,    30,     7,     7,     7,     7,     7,   115,
   115,   116,   116,    61,   153,    61,     8,     8,     8,     8,
     8,     8,     8,     8,     8,     8,     8,     8,     8,     8,
     8,     8,     8,     8,     8,     8,     8,     8,     8,     8,
     8,     8,     8,     8,     8,   131,   131,   131,   131,   131,
   131,   131,   131,   131,   131,   131,   131,   131,   131,   131,
   131,   131,   131,   131,   131,   131,   131,   131,   131,   131,
   131,   131,   131,   131,   131,   131,   131,   131,   131,   131,
   131,   131,   131,   131,   131,   131,   131,   131,   131,   131,
   131,    41,    41,    41,    41,    41,    41,    41,    41,    41,
    41,    41,    41,    41,    41,    41,    41,    41,    41,    41,
    41,    41,    41,    41,    41,    41,    41,    41,    41,    41,
    41,    41,    41,    41,    41,    41,    41,    41,    41,    41,
    41,    41,    41,    41,    41,    73,    76,    76,    76,    76,
    53,    57,    57,   125,   125,   125,   125,   125,    51,    51,
    51,    51,    51,   155,    55,   104,   103,   103,    79,    79,
    79,    79,    35,    35,    70,    70,    70,    42,    42,    42,
    42,    42,    42,    42,    42,    42,    42,    42,   156,    42,
   157,    42,   158,   159,    42,    42,    42,    42,    42,    42,
    42,    42,    42,    42,    42,    42,    42,    42,    42,    42,
    42,    42,    42,   160,   161,    42,   162,   163,    42,    42,
    42,   164,   165,    42,   166,    42,   168,   169,    42,   170,
    42,   171,    42,   172,   173,    42,    42,    42,    42,    42,
    46,   144,   144,   144,   143,   143,    49,    49,    47,    47,
   124,   124,   126,   126,    84,    84,   127,   127,   127,   127,
   127,   127,   127,   127,   127,    91,    91,    91,    91,    90,
    90,    66,    66,    66,    66,    66,    66,    66,    66,    66,
    66,    66,    66,    66,    66,    66,    68,    68,    67,    67,
    67,   119,   119,   118,   118,   128,   128,   174,   175,   121,
    65,    65,   120,   120,   176,   109,    58,    58,    58,    58,
    22,    22,    22,    22,    22,    22,    22,    22,    22,   177,
   108,   178,   108,    74,    48,    48,   113,   113,    75,    75,
    75,    50,    50,    52,    52,    28,    28,    28,    15,    16,
    16,    16,    17,    18,    19,    25,    25,    81,    81,    27,
    27,    87,    87,    85,    85,    26,    26,    88,    88,    80,
    80,    86,    86,    20,    20,    21,    21,    24,    24,    23,
   179,    23,   180,   181,   182,   183,   184,    23,    62,    62,
    62,    62,     2,     1,     1,     1,     1,    29,    33,    33,
    34,    34,    34,    34,    56,    56,    56,    56,    56,    56,
    56,    56,    56,    56,    56,    56,   114,   114,   114,   114,
   114,   114,   114,   114,   114,   114,   114,   114,    63,    63,
   185,    54,    54,    69,   186,    69,    92,    92,    92,    92,
    89,    89,    64,    64,    64,    64,    64,    64,    64,    64,
    64,    64,    64,    64,    64,    64,    64,   132,   132,   132,
   132,     9,     9,   139,   117,   117,    82,    82,   138,    93,
    93,    94,    94,    95,    95,    96,    96,   136,   136,   137,
   137,    60,   123,   102,   102,    83,    83,    11,    11,    13,
    13,    12,    12,   107,   106,   106,    14,   187,    14,    97,
    97,    98,    98,    99,    99,    99,    99,     3,     3,     3,
     4,     4,     4,     4,     5,     5,     5,    10,    10,   141,
   141,   142,   142,   146,   146,   151,   151,   129,   130,   154,
   154,   154,   167,   167,   147,   147,    78,   105,
    }, yyLen = {
//yyLen 648
     2,     0,     2,     2,     1,     1,     3,     2,     1,     0,
     5,     4,     2,     1,     1,     3,     2,     1,     0,     5,
     0,     4,     3,     3,     3,     2,     3,     3,     3,     3,
     3,     4,     1,     3,     3,     6,     5,     5,     5,     5,
     3,     3,     3,     1,     3,     3,     1,     3,     3,     3,
     2,     1,     1,     1,     1,     1,     4,     0,     5,     1,
     2,     3,     4,     5,     4,     5,     2,     2,     2,     2,
     2,     1,     3,     1,     3,     1,     2,     3,     5,     2,
     4,     2,     4,     1,     3,     1,     3,     2,     3,     1,
     3,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     4,     3,     3,     3,     3,     2,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     4,     3,     3,     3,     3,     2,     1,     1,
     1,     2,     1,     3,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     0,     4,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     3,     5,     3,     5,     6,     5,     5,     5,     5,
     4,     3,     3,     3,     3,     3,     3,     3,     3,     3,
     4,     2,     2,     3,     3,     3,     3,     3,     3,     3,
     3,     3,     3,     3,     3,     3,     2,     2,     3,     3,
     3,     3,     3,     6,     1,     1,     1,     2,     4,     2,
     3,     1,     1,     1,     1,     2,     4,     2,     1,     2,
     2,     4,     1,     0,     2,     2,     2,     1,     1,     2,
     3,     4,     1,     1,     3,     4,     2,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     0,     4,
     0,     3,     0,     0,     5,     3,     3,     2,     3,     3,
     1,     4,     3,     1,     5,     4,     3,     2,     1,     2,
     2,     6,     6,     0,     0,     7,     0,     0,     7,     5,
     4,     0,     0,     9,     0,     6,     0,     0,     8,     0,
     5,     0,     6,     0,     0,     9,     1,     1,     1,     1,
     1,     1,     1,     2,     1,     1,     1,     5,     1,     2,
     1,     1,     1,     3,     1,     3,     1,     4,     6,     3,
     5,     2,     4,     1,     3,     4,     2,     2,     1,     2,
     0,     6,     8,     4,     6,     4,     2,     6,     2,     4,
     6,     2,     4,     2,     4,     1,     1,     1,     3,     1,
     4,     1,     4,     1,     3,     1,     1,     0,     0,     4,
     4,     1,     3,     3,     0,     5,     2,     4,     5,     5,
     2,     4,     4,     3,     3,     3,     2,     1,     4,     0,
     5,     0,     5,     5,     1,     1,     6,     0,     1,     1,
     1,     2,     1,     2,     1,     1,     1,     1,     1,     1,
     1,     2,     3,     3,     3,     3,     3,     0,     3,     1,
     2,     3,     3,     0,     3,     3,     3,     3,     3,     0,
     3,     0,     3,     0,     2,     0,     2,     0,     2,     1,
     0,     3,     0,     0,     0,     0,     0,     8,     1,     1,
     1,     1,     2,     1,     1,     1,     1,     3,     1,     2,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     0,     4,     0,     3,     0,     3,     4,     2,     2,     1,
     2,     0,     6,     8,     4,     6,     4,     6,     2,     4,
     6,     2,     4,     2,     4,     1,     0,     1,     1,     1,
     1,     1,     1,     1,     1,     3,     1,     3,     1,     2,
     1,     2,     1,     1,     3,     1,     3,     1,     1,     2,
     1,     3,     3,     1,     3,     1,     3,     1,     1,     2,
     1,     1,     1,     2,     2,     0,     1,     0,     4,     1,
     2,     1,     3,     3,     2,     4,     2,     1,     1,     1,
     1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
     1,     1,     1,     0,     1,     0,     1,     2,     2,     0,
     1,     1,     1,     1,     1,     2,     0,     0,
    }, yyDefRed = {
//yyDefRed 1098
     1,     0,     0,     0,     0,     0,     0,     0,   308,     0,
     0,     0,   333,   336,     0,     0,     0,   358,   359,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     9,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
   459,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,   483,   485,   487,     0,     0,   417,   538,
   539,   510,   513,   511,   512,     0,     0,   456,    59,   298,
     0,   460,   299,   300,     0,   301,   302,   297,   457,    32,
    46,   455,   508,     0,     0,     0,     0,     0,     0,   305,
     0,    54,     0,     0,    85,     0,     4,   303,   304,     0,
     0,    71,     0,     2,     0,     5,     0,     7,   356,   357,
   320,     0,     0,   520,   519,   521,   522,     0,     0,   524,
   523,   525,     0,   516,   515,     0,   518,     0,     0,     0,
     0,   132,     0,   360,     0,   306,     0,   349,   185,   196,
   186,   209,   182,   202,   192,   191,   212,   213,   207,   190,
   189,   184,   210,   214,   215,   194,   183,   197,   201,   203,
   195,   188,   204,   211,   206,     0,     0,     0,     0,   181,
   200,   199,   216,   217,   218,   219,   220,   180,   187,   178,
   179,     0,     0,     0,     0,   136,     0,   170,   171,   167,
   149,   150,   151,   158,   155,   157,   152,   153,   172,   173,
   159,   160,   607,   164,   163,   148,   169,   166,   165,   161,
   162,   156,   154,   146,   168,   147,   174,   351,   137,     0,
   606,   138,   205,   198,   208,   193,   175,   176,   177,   134,
   135,   140,   139,   142,     0,   141,   143,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,   642,   643,
     0,     0,     0,   644,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,   370,   371,     0,     0,     0,     0,     0,   483,     0,
     0,   278,    69,     0,     0,     0,   611,   282,    70,    68,
     0,    67,     0,     0,   436,    66,     0,   636,     0,     0,
    20,     0,     0,     0,   241,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,    14,    13,     0,     0,     0,
     0,     0,   266,     0,     0,     0,   609,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,   257,    50,   256,   505,
   504,   506,   502,   503,     0,     0,     0,     0,     0,     0,
     0,     0,   330,   418,     0,     0,     0,     0,   461,   441,
   439,   329,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,   424,   426,   629,   630,     0,
     0,     0,   632,   631,     0,     0,    87,     0,     0,     0,
     0,     0,     0,     3,     0,   430,     0,   327,     0,   509,
     0,   129,     0,   131,   540,   344,     0,     0,     0,     0,
     0,     0,   627,   628,   353,   144,     0,     0,     0,   362,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,   645,     0,     0,     0,     0,     0,     0,   341,
   614,   289,   285,     0,   616,     0,     0,   279,   287,     0,
   280,     0,   322,     0,   284,   274,   273,     0,     0,     0,
     0,   326,    49,    22,    24,    23,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,   315,    12,
     0,     0,   311,     0,   318,     0,   640,   267,     0,   269,
   319,   610,     0,    89,     0,     0,     0,     0,     0,   492,
   490,   507,   489,   486,   462,   484,   463,   464,   488,   465,
   466,   469,     0,   475,   476,     0,     0,   471,   472,     0,
   477,   478,     0,     0,     0,    26,    27,    28,    29,    30,
    47,    48,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,   433,     0,   435,     0,     0,   622,     0,
     0,   623,   434,   620,   621,     0,    40,     0,     0,    45,
    44,     0,    41,   288,     0,     0,     0,     0,     0,    88,
    33,    42,   292,     0,    34,     0,     6,    57,    61,     0,
     0,     0,     0,     0,     0,   133,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,   309,     0,   363,
     0,     0,     0,     0,     0,     0,     0,     0,     0,   340,
   365,   334,   364,   337,     0,     0,     0,     0,     0,     0,
     0,   613,     0,     0,     0,   286,   612,   321,   637,     0,
     0,   270,   325,    21,     0,     0,    31,     0,     0,     0,
     0,    15,     0,     0,     0,     0,     0,     0,     0,     0,
     0,   493,     0,   468,   470,   480,   572,   569,   568,   567,
   570,   578,   587,     0,     0,   598,   597,   602,   601,   588,
   573,     0,     0,     0,   595,   421,     0,     0,     0,   565,
   585,     0,   549,   576,   571,     0,     0,     0,     0,   474,
   482,   409,     0,   407,     0,   406,     0,     0,     0,     0,
     0,   432,     0,     0,     0,     0,     0,   272,     0,   431,
   271,     0,     0,     0,     0,     0,     0,    86,     0,     0,
     0,     0,   347,     0,     0,   438,   350,   608,     0,     0,
     0,   354,   145,   449,     0,     0,   450,     0,     0,   368,
     0,   366,     0,     0,     0,     0,     0,     0,     0,   339,
     0,     0,     0,     0,     0,     0,   615,   291,   281,     0,
   324,    10,     0,   314,   268,    90,     0,   494,   498,   499,
   500,   491,   501,     0,     0,   372,     0,   374,     0,     0,
   599,   603,     0,   563,     0,     0,   419,     0,   558,     0,
   561,     0,   547,   589,     0,   548,   579,     0,     0,     0,
     0,   405,   583,     0,     0,   388,     0,   593,     0,     0,
     0,     0,     0,     0,     0,     0,    39,     0,    38,     0,
    65,     0,   638,    36,     0,    37,     0,    63,   429,   428,
     0,     0,     0,     0,     0,     0,     0,   541,   345,   543,
   352,   545,     0,     0,     0,   452,   369,     0,    11,   454,
     0,   331,     0,   332,   290,     0,     0,     0,   342,     0,
    19,   495,     0,     0,     0,     0,   575,     0,     0,   550,
   574,     0,     0,     0,     0,   577,     0,   596,     0,   586,
   604,     0,   591,     0,   403,     0,     0,   398,     0,   386,
     0,   401,   408,   387,     0,     0,     0,     0,     0,     0,
   442,   440,     0,   425,    35,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,   451,     0,   453,     0,   444,
   443,   445,   335,   338,     0,   496,   373,     0,     0,     0,
   375,   420,     0,   564,   423,   422,     0,   556,     0,   554,
     0,   559,   562,   546,     0,   389,   410,     0,     0,   584,
     0,     0,     0,   594,   317,     0,     0,   415,     0,   413,
   416,    58,   348,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,   404,     0,   395,     0,   393,   385,     0,   399,   402,
     0,     0,     0,   412,   355,     0,     0,     0,     0,     0,
   446,   367,   343,     0,     0,     0,   557,     0,   552,   555,
   560,     0,     0,     0,     0,   414,     0,   497,     0,     0,
   397,     0,   391,   394,   400,   553,     0,   392,
    }, yyDgoto = {
//yyDgoto 188
     1,   362,    67,    68,   644,   603,   131,   232,   604,   730,
   454,   731,   732,   733,   219,    69,    70,    71,    72,    73,
   365,   364,    74,   543,   367,    75,    76,   552,    77,    78,
   132,    79,    80,    81,    82,   631,   456,   457,   323,   324,
    84,    85,    86,    87,   325,   252,   315,   801,   990,   802,
   904,   495,   908,   605,   445,   301,    89,   769,    90,    91,
   734,   234,   831,   254,   735,   736,   859,   753,   754,   651,
   622,    93,    94,   293,   471,   795,   331,   255,   326,   497,
   371,   369,   737,   738,   836,   375,   377,    97,    98,   843,
   944,  1015,   929,   740,   862,   863,   741,   337,   498,   296,
    99,   534,   864,   487,   297,   488,   852,   742,   437,   416,
   638,   100,   101,   656,   256,   235,   236,   743,  1028,   866,
   846,   372,   328,   867,   283,   499,   837,   838,  1029,   492,
   763,   221,   744,   103,   104,   105,   745,   746,   747,   930,
   136,   448,   424,   671,   460,     2,   261,   262,   312,   516,
   506,   493,   781,   654,   527,   302,   237,   329,   330,   702,
   264,   812,   265,   813,   679,   994,   641,   461,   639,   896,
   449,   451,   653,   902,   373,   556,   598,   564,   563,   712,
   711,   827,   921,   995,  1041,   640,   652,   450,
    }, yySindex = {
//yySindex 1098
     0,     0, 18246, 19543, 21220, 21607, 22349, 22240,     0, 20704,
 20704, 17462,     0,     0, 21349, 18633, 18633,     0,     0, 18633,
  -184,  -174,     0,     0,     0,     0,    97, 22131,   186,     0,
  -159,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0, 20833, 20833,   769,   -52, 18375,     0, 19023, 19413,  4418,
 20833, 20962, 22457,     0,     0,     0,   283,   308,     0,     0,
     0,     0,     0,     0,     0,   310,   321,     0,     0,     0,
   -83,     0,     0,     0,  -193,     0,     0,     0,     0,     0,
     0,     0,     0,  1351,   274,  5872,     0,    54,   630,     0,
   539,     0,    39,   316,     0,   302,     0,     0,     0, 21478,
   349,     0,    95,     0,   141,     0,  -131,     0,     0,     0,
     0,  -184,  -174,     0,     0,     0,     0,   120,   186,     0,
     0,     0,     0,     0,     0,     0,     0,   769, 20704,    11,
 18504,     0,   168,     0,   743,     0,  -131,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,   -76,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,   516,     0,     0, 18504,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
   257,   274,    89,   771,   236,   517,   262,    89,     0,     0,
   141,   320,   552,     0, 20704, 20704,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,   309,   844,
     0,     0,     0,   335, 20833, 20833, 20833, 20833,     0, 20833,
  5872,     0,     0,   296,   596,   605,     0,     0,     0,     0,
 15943,     0, 18633, 18633,     0,     0, 17720,     0, 20704,   -81,
     0, 19801,   294, 18504,     0,  1009,   352,   356,   348, 19672,
     0, 18375,   362,   141,  1351,     0,     0,     0,   186,   186,
 20704,   361,     0,   154,   162,   296,     0,   347,   162,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,   402, 21736,  1065,     0,   672,     0,     0,     0,     0,
     0,     0,     0,     0,   766,   996,  1066,   642,   346,  1118,
   350,   -86,     0,     0,   380,  1140,   383,   -60,     0,     0,
     0,     0, 20704, 20704, 20704, 20704, 19672, 20704, 20704, 20833,
 20833, 20833, 20833, 20833, 20833, 20833, 20833, 20833, 20833, 20833,
 20833, 20833, 20833, 20833, 20833, 20833, 20833, 20833, 20833, 20833,
 20833, 20833, 20833, 20833, 20833,     0,     0,     0,     0,  5971,
 18633,  6347,     0,     0,  4981, 20962,     0, 19930, 18375, 17859,
   714, 19930, 20962,     0, 17988,     0,   417,     0,   425,     0,
   274,     0,     0,     0,     0,     0, 11391, 18633, 11913, 18504,
 20704,   429,     0,     0,     0,     0,   510,   523,   348,     0,
 18504,   513, 12448, 18633, 22621, 20833, 20833, 20833, 18504,   320,
 20059,   525,     0,    81,    81,     0, 22677, 18633, 22733,     0,
     0,     0,     0,   413,     0, 20833, 18763,     0,     0, 19153,
     0,   186,     0,   450,     0,     0,     0,   753,   754,   186,
    76,     0,     0,     0,     0,     0, 22240, 20704,  5872, 18246,
   444, 12448, 22621, 20833, 20833,  1351,   446,   186,     0,     0,
 18117,     0,     0,   274,     0, 19283,     0,     0, 19413,     0,
     0,     0,     0,     0,   767, 22789, 18633, 22845, 21736,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,   -21,     0,     0,   785,  2447,     0,     0,   201,
     0,     0,   787,  -151,  -151,     0,     0,     0,     0,     0,
     0,     0,   352,  2374,  2374,  2374,  2374,  2309,  2309,  3425,
  2913,  2374,  2374,  4925,  4925,  1043,  1043,   352,  2749,   352,
   352,   489,   489,  2309,  2309,  1396,  1396, 10862,  -151,   485,
     0,   490,  -174,     0,     0,     0,   186,   492,     0,   503,
  -174,     0,     0,     0,     0,  -174,     0,  5872, 20833,     0,
     0,  5360,     0,     0,   783,   805,   186, 21736,   810,     0,
     0,     0,     0,     0,     0,  5499,     0,     0,     0,   141,
 20704, 18504,     0,     0,  -174,     0,   186,  -174,   600,    76,
  4495, 18504,  4495, 22565, 22240, 20188,   604,     0,   390,     0,
   527,   541,   186,   545,   547,  5360,   604,   613,   689,     0,
     0,     0,     0,     0,     0,     0,   186,     0,     0, 20704,
 20833,     0, 20833,   296,   605,     0,     0,     0,     0, 18763,
 19153,     0,     0,     0,    76,   524,     0,   352,  5872, 18246,
     0,     0,   186,   162, 21736,     0,     0,   186,     0,     0,
   767,     0,   369,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,  1555,  4495,     0,     0,     0,     0,     0,
     0,   586,   587,   846,     0,     0,  -161,   851,   853,     0,
     0,   861,     0,     0,     0,   603,   869, 20833,   855,     0,
     0,     0,   856,     0, 18504,     0, 18504,   871, 18504, 20962,
 20962,     0,   417,   595,   579, 20962, 20962,     0,   417,     0,
     0,    54,  -193,     0, 20833, 20962, 20317,     0,   767, 21736,
 20833,  -151,     0,   141,   663,     0,     0,     0,   186,   673,
   141,     0,     0,     0,     0,   597,     0, 18504,   679,     0,
 20704,     0,   683, 20833, 20833,   608, 20833, 20833,   703,     0,
 20446, 18504, 18504, 18504,     0,    81,     0,     0,     0,   927,
     0,     0,   610,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,  1555,   737,     0,   933,     0,   186,   186,
     0,     0,  1935,     0, 18504, 18504,     0,  4495,     0,  4495,
     0,   401,     0,     0,   345,     0,     0, 20833,   941,   186,
   942,     0,     0,   946,   949,     0,   636,     0,   869, 21865,
   943,   948,   745,   655, 20833,   755,     0,  5872,     0,  5872,
     0, 20962,     0,     0,  5872,     0,  5872,     0,     0,     0,
  5872, 20833,     0,   767,  5872, 18504, 18504,     0,     0,     0,
     0,     0,   429, 21994,    89,     0,     0, 18504,     0,     0,
    89,     0, 20833,     0,     0,    83,   759,   760,     0, 19153,
     0,     0,   186,   909,   982,  2284,     0,   687,   992,     0,
     0,   778,   686,  1006,  1011,     0,  1015,     0,   992,     0,
     0,   869,     0,  1935,     0,   701,  4495,     0,   401,     0,
  4495,     0,     0,     0,     0,     0,   756,  1139, 21865,  1304,
     0,     0,  5872,     0,     0,  5872,     0,   700,   801, 18504,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,   763,  1145,     0,     0, 18504,     0, 18504,     0,
     0,     0,     0,     0, 18504,     0,     0,  1036,   909,  1240,
     0,     0,  1935,     0,     0,     0,  1935,     0,  4495,     0,
  1935,     0,     0,     0,  1050,     0,     0,  1052,  1057,     0,
   869,  1058,  1050,     0,     0, 22901,  1139,     0,   178,     0,
     0,     0,     0,   823,     0, 22957, 18633, 23013,   510,   390,
   852, 18504,   909,  1036,   909,  1064,   992,  1071,   992,   992,
  1935,     0,  1935,     0,  4495,     0,     0,  1935,     0,     0,
     0,     0,  1304,     0,     0,     0,     0,   186,     0,     0,
     0,     0,     0,   724,  1036,   909,     0,  1935,     0,     0,
     0,  1050,  1078,  1050,  1050,     0,     0,     0,  1036,   992,
     0,  1935,     0,     0,     0,     0,  1050,     0,
    }, yyRindex = {
//yyRindex 1098
     0,     0,   289,     0,     0,     0,     0,     0,     0,     0,
     0,   854,     0,     0,     0,  9623,  9732,     0,     0,  9838,
  4730,  4218, 10810, 10993, 11111, 11214, 21091,     0, 20575,     0,
     0, 11324, 11515, 11625,  5092,  3194, 11728, 11846,  5231, 12029,
     0,     0,     0,     0,     0,   118, 17591,   781,   794,    55,
     0,     0,  1164,     0,     0,     0,  1191,   -43,     0,     0,
     0,     0,     0,     0,     0,  1208,   -34,     0,     0,     0,
  8814,     0,     0,     0,  9011,     0,     0,     0,     0,     0,
     0,     0,     0,    62,  9230,  1336,  9120,  8311,     0,     0,
  8617,     0, 12147,     0,     0,     0,     0,     0,     0,   266,
     0,     0,     0,     0,    29,     0, 18893,     0,     0,     0,
     0,  9317,  6628,     0,     0,     0,     0,     0,   820,     0,
     0,     0, 16082,     0,     0, 16223,     0,     0,     0,     0,
   118,     0, 17063,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,  1500,  2272,  2784,  2871,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,  3296,  3383,  3808,  3895,     0,  4320,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0, 15849,     0,     0,   849,  6869,  6978,
  7175,  7284,  7481,  7590,  7787,  2031,  7896,  8093,  2170,  8202,
     0,  6733,     0,     0,  8508,     0,     0,     0,     0,     0,
   854,     0,   900,     0,     0,     0,   897,  1337,  1550,  1710,
  2457,  2870,  2969,   566,  3382,  3481,  2318,  3854,     0,     0,
  3894,     0,     0,     0,     0,     0,     0,     0,     0,     0,
 15378,     0,     0,  9565,  7087,  7087,     0,     0,     0,     0,
   836,     0,     0,    75,     0,     0,   836,     0,     0,     0,
     0,     0,     0,    73,     0,     0,  9961,  9426, 12250,     0,
 16922,   118,     0,  2306,   558,     0,     0,   175,   836,   836,
     0,     0,     0,   840,   840,     0,     0,     0,   825,  1225,
  1746,  6119,  7080,  7082,  7387,  7998,   973,  8009,  8302,  5421,
  8304,     0,     0,     0,  8315,   270,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
    66,     0,     0,     0,     0,     0,     0,     0,   118,   276,
   304,     0,     0,     0,    49,     0,  7393,     0,     0,     0,
   148,     0, 16642,     0,     0,     0,     0,    66,     0,   849,
     0,   780,     0,     0,     0,     0,    15,     0,  8705,     0,
   691, 16783,     0,    66,     0,     0,     0,     0,   100,     0,
     0,     0,     0,     0,     0,  3993,     0,    66,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,   836,     0,     0,     0,     0,     0,    16,    16,   836,
   836,     0,     0,     0,     0,     0,     0,     0,  4922,    73,
     0,     0,     0,     0,     0,   589,     0,   836,     0,     0,
  2347,   237,     0,   177,     0,   848,     0,     0,  -185,     0,
     0,     0,  8610,     0,   459,     0,    66,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,  -149,     0,     0,     0,
     0,     0,     0, 17193, 17332,     0,     0,     0,     0,     0,
     0,     0, 10082,  1816, 13745, 13833, 13921, 13258, 13375, 14018,
 14291, 14106, 14194, 14379, 14467, 12675, 12785, 10202, 12920, 10311,
 10446, 12369, 12556, 13531, 13648, 13029, 13149,  1153, 17193,  5604,
  3567,  6255, 18893,     0,  3706,     0,   858,  5743,     0,  6116,
  4591,     0,     0,     0,     0,  6494,     0, 14556,     0,     0,
     0, 15792,     0,     0,     0,     0,   836,     0,   514,     0,
     0,     0,     0,  1888,     0, 15467,     0,     0,     0,     0,
     0,   849, 16362, 16503,     0,     0,   858,  8399,     0,   836,
   194,   849,   152,     0,     0,   715,   468,     0,   934,     0,
  2543,  4079,   858,  2682,  3055, 15576,   934,     0,     0,     0,
     0,     0,     0,     0,  2358,  1548,   858,  2830,  3342,     0,
     0,     0,     0, 15638,  7087,     0,     0,     0,     0,    53,
    71,     0,     0,     0,   836,     0,     0, 10584, 14645,    73,
   173,     0,   836,   840,     0,  5933,   733,   858,  7392,  7698,
   576,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,   187,     0,     0,     0,     0,     0,
     0,   176,     0,   287,     0,     0,     0,   287,   287,     0,
     0,   300,     0,     0,     0,   179,   300,   136,   264,     0,
     0,     0,    14,     0,   229,     0,    73,     0,   229,     0,
     0,     0,  7699, 10687,     0,     0,     0,     0,  8005,     0,
     0,  8923,   112, 15483,     0,     0,     0,     0,   584,     0,
     0, 17332,     0,     0,     0,     0,     0,     0,   836,     0,
     0,     0,     0,     0,   611,   682,     0,   712,   934,     0,
     0,     0,     0,     0,     0,  1649,     0,     0,     0,     0,
     0,   928,   229,   229,   824,     0,     0,     0,     0,    16,
     0,     0,     0,     0,     0,     0,  1249,     0,     0,     0,
     0,     0,     0,     0,   202,     0,   234,     0,   836,    -4,
     0,     0,     0,     0,   229,    73,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,   132,    14,
   132,     0,     0,   142,   132,     0,     0,     0,   142,    80,
   117,  -160,     0,     0,     0,     0,     0, 14707,     0, 14816,
     0,     0,     0,     0, 14905,     0, 14967,     0,     0,     0,
 15056,     0, 15696,   592, 15165,    73,   849,     0,     0,     0,
     0,     0,   780,     0,     0,     0,     0,   229,     0,     0,
     0,     0,     0,     0,     0,   934,     0,     0,     0,   137,
     0,     0,   836,     0,   235,     0,     0,     0,   287,     0,
     0,     0,     0,   287,   287,     0,   287,     0,   287,     0,
     0,   300,     0,     0,     0,     0,   143,     0,     0,     0,
     0,     0,     0,     0,   920,  1023,     0,   131,     0,     0,
     0,     0, 15227,     0,     0, 15316, 15756,     0,     0,   849,
   866,  1862,  1899,  1928,  1938,  2411,  2923,  1122,  3435,  3947,
  7085,  7051,     0,     0,  7063,     0,   849,     0,   691,     0,
     0,     0,     0,     0,   229,     0,     0,   243,     0,   247,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,   132,     0,     0,   132,   132,     0,
   142,   132,   132,     0,     0,     0,   135,     0,   -69,     0,
     0,     0,     0,     0,  7396,     0,    66,     0,    15,   934,
     0,    56,     0,   251,     0,   253,   287,   287,   287,   287,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
  1247,  1230,     0,     0,     0,  8926,  1728,   858,  9536,  9538,
     0,     0,     0,     0,   255,     0,     0,     0,     0,     0,
     0,   132,   132,   132,   132,     0,   910,     0,   259,   287,
     0,     0,     0,     0,     0,     0,   132,     0,
    }, yyGindex = {
//yyGindex 188
     0,     0,    51,     0,  -344,     0,     9,    30,    44,   147,
     0,     0,     0,   471,     0,     0,     0,  1144,     0,     0,
   936,  1167,     0,  2192,     0,     0,     0,   867,     0,    57,
  1222,  -404,   -31,     0,   127,     0,   695,  -422,     0,    28,
  1047,  1368,    20,    26,   727,    36,     3,  -451,     0,   205,
     0,   929,     0,    -6,     0,   -12,  1248,   643,     0,     0,
  -744,     0,     0,   483,  -487,     0,     0,     0,  -461,   358,
  -393,   -40,    -5,  1045,  -448,     0,     0,   649,   707,    82,
     0,     0,  1110,   416,  -750,     0,     0,     0,     0,    94,
  1195,   512,  -375,   422,   327,     0,     0,     0,    41,  -449,
     0,  -477,   322,  -285,  -419,     0,   -80,   571,   -58,   506,
  -544,  1264,    -2,   245,   454,     0,   -23,  -314,     0,  -704,
     0,     0,  -207,  -807,     0,  -352,  -817,   452,   225,   116,
  -553,     0,  -846,  -392,     0,    25,     0,   768,   976,  -420,
   240,   -87,     0,  -437,  -225,     0,   -51,   -30,     0,     0,
     0,   -26,     0,     0,  -299,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,    22,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
     0,     0,     0,     0,     0,     0,     0,     0,
    };
    protected static final short[] yyTable = YyTables.yyTable();
    protected static final short[] yyCheck = YyTables.yyCheck();

  /** maps symbol value to printable name.
      @see #yyExpecting
    */
  protected static final String[] yyNames = {
    "end-of-file",null,null,null,null,null,null,null,null,null,"'\\n'",
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,"' '",null,null,null,null,null,
    null,null,null,null,null,null,"','",null,null,null,null,null,null,
    null,null,null,null,null,null,null,"':'","';'",null,"'='",null,"'?'",
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,
    "'['",null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,null,
    null,null,null,null,null,null,null,null,null,null,null,null,null,
    "keyword_class","keyword_module","keyword_def","keyword_undef",
    "keyword_begin","keyword_rescue","keyword_ensure","keyword_end",
    "keyword_if","keyword_unless","keyword_then","keyword_elsif",
    "keyword_else","keyword_case","keyword_when","keyword_while",
    "keyword_until","keyword_for","keyword_break","keyword_next",
    "keyword_redo","keyword_retry","keyword_in","keyword_do",
    "keyword_do_cond","keyword_do_block","keyword_return","keyword_yield",
    "keyword_super","keyword_self","keyword_nil","keyword_true",
    "keyword_false","keyword_and","keyword_or","keyword_not",
    "modifier_if","modifier_unless","modifier_while","modifier_until",
    "modifier_rescue","keyword_alias","keyword_defined","keyword_BEGIN",
    "keyword_END","keyword__LINE__","keyword__FILE__",
    "keyword__ENCODING__","keyword_do_lambda","tIDENTIFIER","tFID",
    "tGVAR","tIVAR","tCONSTANT","tCVAR","tLABEL","tCHAR","tUPLUS",
    "tUMINUS","tUMINUS_NUM","tPOW","tCMP","tEQ","tEQQ","tNEQ","tGEQ",
    "tLEQ","tANDOP","tOROP","tMATCH","tNMATCH","tDOT","tDOT2","tDOT3",
    "tAREF","tASET","tLSHFT","tRSHFT","tANDDOT","tCOLON2","tCOLON3",
    "tOP_ASGN","tASSOC","tLPAREN","tLPAREN2","tRPAREN","tLPAREN_ARG",
    "tLBRACK","tRBRACK","tLBRACE","tLBRACE_ARG","tSTAR","tSTAR2","tAMPER",
    "tAMPER2","tTILDE","tPERCENT","tDIVIDE","tPLUS","tMINUS","tLT","tGT",
    "tPIPE","tBANG","tCARET","tLCURLY","tRCURLY","tBACK_REF2","tSYMBEG",
    "tSTRING_BEG","tXSTRING_BEG","tREGEXP_BEG","tWORDS_BEG","tQWORDS_BEG",
    "tSTRING_DBEG","tSTRING_DVAR","tSTRING_END","tLAMBDA","tLAMBEG",
    "tNTH_REF","tBACK_REF","tSTRING_CONTENT","tINTEGER","tIMAGINARY",
    "tFLOAT","tRATIONAL","tREGEXP_END","tIGNORED_NL","tCOMMENT",
    "tEMBDOC_BEG","tEMBDOC","tEMBDOC_END","tSP","tHEREDOC_BEG",
    "tHEREDOC_END","tSYMBOLS_BEG","tQSYMBOLS_BEG","tDSTAR","tSTRING_DEND",
    "tLABEL_END","tLOWEST","k__END__",
    };

  /** printable rules for debugging.
    */
  protected static final String [] yyRule = {
    "$accept : program",
    "$$1 :",
    "program : $$1 top_compstmt",
    "top_compstmt : top_stmts opt_terms",
    "top_stmts : none",
    "top_stmts : top_stmt",
    "top_stmts : top_stmts terms top_stmt",
    "top_stmts : error top_stmt",
    "top_stmt : stmt",
    "$$2 :",
    "top_stmt : keyword_BEGIN $$2 tLCURLY top_compstmt tRCURLY",
    "bodystmt : compstmt opt_rescue opt_else opt_ensure",
    "compstmt : stmts opt_terms",
    "stmts : none",
    "stmts : stmt_or_begin",
    "stmts : stmts terms stmt_or_begin",
    "stmts : error stmt",
    "stmt_or_begin : stmt",
    "$$3 :",
    "stmt_or_begin : keyword_begin $$3 tLCURLY top_compstmt tRCURLY",
    "$$4 :",
    "stmt : keyword_alias fitem $$4 fitem",
    "stmt : keyword_alias tGVAR tGVAR",
    "stmt : keyword_alias tGVAR tBACK_REF",
    "stmt : keyword_alias tGVAR tNTH_REF",
    "stmt : keyword_undef undef_list",
    "stmt : stmt modifier_if expr_value",
    "stmt : stmt modifier_unless expr_value",
    "stmt : stmt modifier_while expr_value",
    "stmt : stmt modifier_until expr_value",
    "stmt : stmt modifier_rescue stmt",
    "stmt : keyword_END tLCURLY compstmt tRCURLY",
    "stmt : command_asgn",
    "stmt : mlhs '=' command_call",
    "stmt : var_lhs tOP_ASGN command_call",
    "stmt : primary_value '[' opt_call_args rbracket tOP_ASGN command_call",
    "stmt : primary_value call_op tIDENTIFIER tOP_ASGN command_call",
    "stmt : primary_value call_op tCONSTANT tOP_ASGN command_call",
    "stmt : primary_value tCOLON2 tCONSTANT tOP_ASGN command_call",
    "stmt : primary_value tCOLON2 tIDENTIFIER tOP_ASGN command_call",
    "stmt : backref tOP_ASGN command_call",
    "stmt : lhs '=' mrhs",
    "stmt : mlhs '=' mrhs_arg",
    "stmt : expr",
    "command_asgn : lhs '=' command_call",
    "command_asgn : lhs '=' command_asgn",
    "expr : command_call",
    "expr : expr keyword_and expr",
    "expr : expr keyword_or expr",
    "expr : keyword_not opt_nl expr",
    "expr : tBANG command_call",
    "expr : arg",
    "expr_value : expr",
    "command_call : command",
    "command_call : block_command",
    "block_command : block_call",
    "block_command : block_call call_op2 operation2 command_args",
    "$$5 :",
    "cmd_brace_block : tLBRACE_ARG $$5 opt_block_param compstmt tRCURLY",
    "fcall : operation",
    "command : fcall command_args",
    "command : fcall command_args cmd_brace_block",
    "command : primary_value call_op operation2 command_args",
    "command : primary_value call_op operation2 command_args cmd_brace_block",
    "command : primary_value tCOLON2 operation2 command_args",
    "command : primary_value tCOLON2 operation2 command_args cmd_brace_block",
    "command : keyword_super command_args",
    "command : keyword_yield command_args",
    "command : keyword_return call_args",
    "command : keyword_break call_args",
    "command : keyword_next call_args",
    "mlhs : mlhs_basic",
    "mlhs : tLPAREN mlhs_inner rparen",
    "mlhs_inner : mlhs_basic",
    "mlhs_inner : tLPAREN mlhs_inner rparen",
    "mlhs_basic : mlhs_head",
    "mlhs_basic : mlhs_head mlhs_item",
    "mlhs_basic : mlhs_head tSTAR mlhs_node",
    "mlhs_basic : mlhs_head tSTAR mlhs_node ',' mlhs_post",
    "mlhs_basic : mlhs_head tSTAR",
    "mlhs_basic : mlhs_head tSTAR ',' mlhs_post",
    "mlhs_basic : tSTAR mlhs_node",
    "mlhs_basic : tSTAR mlhs_node ',' mlhs_post",
    "mlhs_basic : tSTAR",
    "mlhs_basic : tSTAR ',' mlhs_post",
    "mlhs_item : mlhs_node",
    "mlhs_item : tLPAREN mlhs_inner rparen",
    "mlhs_head : mlhs_item ','",
    "mlhs_head : mlhs_head mlhs_item ','",
    "mlhs_post : mlhs_item",
    "mlhs_post : mlhs_post ',' mlhs_item",
    "mlhs_node : tIDENTIFIER",
    "mlhs_node : tIVAR",
    "mlhs_node : tGVAR",
    "mlhs_node : tCONSTANT",
    "mlhs_node : tCVAR",
    "mlhs_node : keyword_nil",
    "mlhs_node : keyword_self",
    "mlhs_node : keyword_true",
    "mlhs_node : keyword_false",
    "mlhs_node : keyword__FILE__",
    "mlhs_node : keyword__LINE__",
    "mlhs_node : keyword__ENCODING__",
    "mlhs_node : primary_value '[' opt_call_args rbracket",
    "mlhs_node : primary_value call_op tIDENTIFIER",
    "mlhs_node : primary_value tCOLON2 tIDENTIFIER",
    "mlhs_node : primary_value call_op tCONSTANT",
    "mlhs_node : primary_value tCOLON2 tCONSTANT",
    "mlhs_node : tCOLON3 tCONSTANT",
    "mlhs_node : backref",
    "lhs : tIDENTIFIER",
    "lhs : tIVAR",
    "lhs : tGVAR",
    "lhs : tCONSTANT",
    "lhs : tCVAR",
    "lhs : keyword_nil",
    "lhs : keyword_self",
    "lhs : keyword_true",
    "lhs : keyword_false",
    "lhs : keyword__FILE__",
    "lhs : keyword__LINE__",
    "lhs : keyword__ENCODING__",
    "lhs : primary_value '[' opt_call_args rbracket",
    "lhs : primary_value call_op tIDENTIFIER",
    "lhs : primary_value tCOLON2 tIDENTIFIER",
    "lhs : primary_value call_op tCONSTANT",
    "lhs : primary_value tCOLON2 tCONSTANT",
    "lhs : tCOLON3 tCONSTANT",
    "lhs : backref",
    "cname : tIDENTIFIER",
    "cname : tCONSTANT",
    "cpath : tCOLON3 cname",
    "cpath : cname",
    "cpath : primary_value tCOLON2 cname",
    "fname : tIDENTIFIER",
    "fname : tCONSTANT",
    "fname : tFID",
    "fname : op",
    "fname : reswords",
    "fsym : fname",
    "fsym : symbol",
    "fitem : fsym",
    "fitem : dsym",
    "undef_list : fitem",
    "$$6 :",
    "undef_list : undef_list ',' $$6 fitem",
    "op : tPIPE",
    "op : tCARET",
    "op : tAMPER2",
    "op : tCMP",
    "op : tEQ",
    "op : tEQQ",
    "op : tMATCH",
    "op : tNMATCH",
    "op : tGT",
    "op : tGEQ",
    "op : tLT",
    "op : tLEQ",
    "op : tNEQ",
    "op : tLSHFT",
    "op : tRSHFT",
    "op : tPLUS",
    "op : tMINUS",
    "op : tSTAR2",
    "op : tSTAR",
    "op : tDIVIDE",
    "op : tPERCENT",
    "op : tPOW",
    "op : tBANG",
    "op : tTILDE",
    "op : tUPLUS",
    "op : tUMINUS",
    "op : tAREF",
    "op : tASET",
    "op : tBACK_REF2",
    "reswords : keyword__LINE__",
    "reswords : keyword__FILE__",
    "reswords : keyword__ENCODING__",
    "reswords : keyword_BEGIN",
    "reswords : keyword_END",
    "reswords : keyword_alias",
    "reswords : keyword_and",
    "reswords : keyword_begin",
    "reswords : keyword_break",
    "reswords : keyword_case",
    "reswords : keyword_class",
    "reswords : keyword_def",
    "reswords : keyword_defined",
    "reswords : keyword_do",
    "reswords : keyword_else",
    "reswords : keyword_elsif",
    "reswords : keyword_end",
    "reswords : keyword_ensure",
    "reswords : keyword_false",
    "reswords : keyword_for",
    "reswords : keyword_in",
    "reswords : keyword_module",
    "reswords : keyword_next",
    "reswords : keyword_nil",
    "reswords : keyword_not",
    "reswords : keyword_or",
    "reswords : keyword_redo",
    "reswords : keyword_rescue",
    "reswords : keyword_retry",
    "reswords : keyword_return",
    "reswords : keyword_self",
    "reswords : keyword_super",
    "reswords : keyword_then",
    "reswords : keyword_true",
    "reswords : keyword_undef",
    "reswords : keyword_when",
    "reswords : keyword_yield",
    "reswords : keyword_if",
    "reswords : keyword_unless",
    "reswords : keyword_while",
    "reswords : keyword_until",
    "reswords : modifier_if",
    "reswords : modifier_unless",
    "reswords : modifier_while",
    "reswords : modifier_until",
    "reswords : modifier_rescue",
    "arg : lhs '=' arg",
    "arg : lhs '=' arg modifier_rescue arg",
    "arg : var_lhs tOP_ASGN arg",
    "arg : var_lhs tOP_ASGN arg modifier_rescue arg",
    "arg : primary_value '[' opt_call_args rbracket tOP_ASGN arg",
    "arg : primary_value call_op tIDENTIFIER tOP_ASGN arg",
    "arg : primary_value call_op tCONSTANT tOP_ASGN arg",
    "arg : primary_value tCOLON2 tIDENTIFIER tOP_ASGN arg",
    "arg : primary_value tCOLON2 tCONSTANT tOP_ASGN arg",
    "arg : tCOLON3 tCONSTANT tOP_ASGN arg",
    "arg : backref tOP_ASGN arg",
    "arg : arg tDOT2 arg",
    "arg : arg tDOT3 arg",
    "arg : arg tPLUS arg",
    "arg : arg tMINUS arg",
    "arg : arg tSTAR2 arg",
    "arg : arg tDIVIDE arg",
    "arg : arg tPERCENT arg",
    "arg : arg tPOW arg",
    "arg : tUMINUS_NUM simple_numeric tPOW arg",
    "arg : tUPLUS arg",
    "arg : tUMINUS arg",
    "arg : arg tPIPE arg",
    "arg : arg tCARET arg",
    "arg : arg tAMPER2 arg",
    "arg : arg tCMP arg",
    "arg : arg tGT arg",
    "arg : arg tGEQ arg",
    "arg : arg tLT arg",
    "arg : arg tLEQ arg",
    "arg : arg tEQ arg",
    "arg : arg tEQQ arg",
    "arg : arg tNEQ arg",
    "arg : arg tMATCH arg",
    "arg : arg tNMATCH arg",
    "arg : tBANG arg",
    "arg : tTILDE arg",
    "arg : arg tLSHFT arg",
    "arg : arg tRSHFT arg",
    "arg : arg tANDOP arg",
    "arg : arg tOROP arg",
    "arg : keyword_defined opt_nl arg",
    "arg : arg '?' arg opt_nl ':' arg",
    "arg : primary",
    "arg_value : arg",
    "aref_args : none",
    "aref_args : args trailer",
    "aref_args : args ',' assocs trailer",
    "aref_args : assocs trailer",
    "paren_args : tLPAREN2 opt_call_args rparen",
    "opt_paren_args : none",
    "opt_paren_args : paren_args",
    "opt_call_args : none",
    "opt_call_args : call_args",
    "opt_call_args : args ','",
    "opt_call_args : args ',' assocs ','",
    "opt_call_args : assocs ','",
    "call_args : command",
    "call_args : args opt_block_arg",
    "call_args : assocs opt_block_arg",
    "call_args : args ',' assocs opt_block_arg",
    "call_args : block_arg",
    "$$7 :",
    "command_args : $$7 call_args",
    "block_arg : tAMPER arg_value",
    "opt_block_arg : ',' block_arg",
    "opt_block_arg : none_block_pass",
    "args : arg_value",
    "args : tSTAR arg_value",
    "args : args ',' arg_value",
    "args : args ',' tSTAR arg_value",
    "mrhs_arg : mrhs",
    "mrhs_arg : arg_value",
    "mrhs : args ',' arg_value",
    "mrhs : args ',' tSTAR arg_value",
    "mrhs : tSTAR arg_value",
    "primary : literal",
    "primary : strings",
    "primary : xstring",
    "primary : regexp",
    "primary : words",
    "primary : qwords",
    "primary : symbols",
    "primary : qsymbols",
    "primary : var_ref",
    "primary : backref",
    "primary : tFID",
    "$$8 :",
    "primary : keyword_begin $$8 bodystmt keyword_end",
    "$$9 :",
    "primary : tLPAREN_ARG $$9 rparen",
    "$$10 :",
    "$$11 :",
    "primary : tLPAREN_ARG $$10 expr $$11 rparen",
    "primary : tLPAREN compstmt tRPAREN",
    "primary : primary_value tCOLON2 tCONSTANT",
    "primary : tCOLON3 tCONSTANT",
    "primary : tLBRACK aref_args tRBRACK",
    "primary : tLBRACE assoc_list tRCURLY",
    "primary : keyword_return",
    "primary : keyword_yield tLPAREN2 call_args rparen",
    "primary : keyword_yield tLPAREN2 rparen",
    "primary : keyword_yield",
    "primary : keyword_defined opt_nl tLPAREN2 expr rparen",
    "primary : keyword_not tLPAREN2 expr rparen",
    "primary : keyword_not tLPAREN2 rparen",
    "primary : fcall brace_block",
    "primary : method_call",
    "primary : method_call brace_block",
    "primary : tLAMBDA lambda",
    "primary : keyword_if expr_value then compstmt if_tail keyword_end",
    "primary : keyword_unless expr_value then compstmt opt_else keyword_end",
    "$$12 :",
    "$$13 :",
    "primary : keyword_while $$12 expr_value do $$13 compstmt keyword_end",
    "$$14 :",
    "$$15 :",
    "primary : keyword_until $$14 expr_value do $$15 compstmt keyword_end",
    "primary : keyword_case expr_value opt_terms case_body keyword_end",
    "primary : keyword_case opt_terms case_body keyword_end",
    "$$16 :",
    "$$17 :",
    "primary : keyword_for for_var keyword_in $$16 expr_value do $$17 compstmt keyword_end",
    "$$18 :",
    "primary : keyword_class cpath superclass $$18 bodystmt keyword_end",
    "$$19 :",
    "$$20 :",
    "primary : keyword_class tLSHFT expr $$19 term $$20 bodystmt keyword_end",
    "$$21 :",
    "primary : keyword_module cpath $$21 bodystmt keyword_end",
    "$$22 :",
    "primary : keyword_def fname $$22 f_arglist bodystmt keyword_end",
    "$$23 :",
    "$$24 :",
    "primary : keyword_def singleton dot_or_colon $$23 fname $$24 f_arglist bodystmt keyword_end",
    "primary : keyword_break",
    "primary : keyword_next",
    "primary : keyword_redo",
    "primary : keyword_retry",
    "primary_value : primary",
    "then : term",
    "then : keyword_then",
    "then : term keyword_then",
    "do : term",
    "do : keyword_do_cond",
    "if_tail : opt_else",
    "if_tail : keyword_elsif expr_value then compstmt if_tail",
    "opt_else : none",
    "opt_else : keyword_else compstmt",
    "for_var : lhs",
    "for_var : mlhs",
    "f_marg : f_norm_arg",
    "f_marg : tLPAREN f_margs rparen",
    "f_marg_list : f_marg",
    "f_marg_list : f_marg_list ',' f_marg",
    "f_margs : f_marg_list",
    "f_margs : f_marg_list ',' tSTAR f_norm_arg",
    "f_margs : f_marg_list ',' tSTAR f_norm_arg ',' f_marg_list",
    "f_margs : f_marg_list ',' tSTAR",
    "f_margs : f_marg_list ',' tSTAR ',' f_marg_list",
    "f_margs : tSTAR f_norm_arg",
    "f_margs : tSTAR f_norm_arg ',' f_marg_list",
    "f_margs : tSTAR",
    "f_margs : tSTAR ',' f_marg_list",
    "block_args_tail : f_block_kwarg ',' f_kwrest opt_f_block_arg",
    "block_args_tail : f_block_kwarg opt_f_block_arg",
    "block_args_tail : f_kwrest opt_f_block_arg",
    "block_args_tail : f_block_arg",
    "opt_block_args_tail : ',' block_args_tail",
    "opt_block_args_tail :",
    "block_param : f_arg ',' f_block_optarg ',' f_rest_arg opt_block_args_tail",
    "block_param : f_arg ',' f_block_optarg ',' f_rest_arg ',' f_arg opt_block_args_tail",
    "block_param : f_arg ',' f_block_optarg opt_block_args_tail",
    "block_param : f_arg ',' f_block_optarg ',' f_arg opt_block_args_tail",
    "block_param : f_arg ',' f_rest_arg opt_block_args_tail",
    "block_param : f_arg ','",
    "block_param : f_arg ',' f_rest_arg ',' f_arg opt_block_args_tail",
    "block_param : f_arg opt_block_args_tail",
    "block_param : f_block_optarg ',' f_rest_arg opt_block_args_tail",
    "block_param : f_block_optarg ',' f_rest_arg ',' f_arg opt_block_args_tail",
    "block_param : f_block_optarg opt_block_args_tail",
    "block_param : f_block_optarg ',' f_arg opt_block_args_tail",
    "block_param : f_rest_arg opt_block_args_tail",
    "block_param : f_rest_arg ',' f_arg opt_block_args_tail",
    "block_param : block_args_tail",
    "opt_block_param : none",
    "opt_block_param : block_param_def",
    "block_param_def : tPIPE opt_bv_decl tPIPE",
    "block_param_def : tOROP",
    "block_param_def : tPIPE block_param opt_bv_decl tPIPE",
    "opt_bv_decl : opt_nl",
    "opt_bv_decl : opt_nl ';' bv_decls opt_nl",
    "bv_decls : bvar",
    "bv_decls : bv_decls ',' bvar",
    "bvar : tIDENTIFIER",
    "bvar : f_bad_arg",
    "$$25 :",
    "$$26 :",
    "lambda : $$25 $$26 f_larglist lambda_body",
    "f_larglist : tLPAREN2 f_args opt_bv_decl tRPAREN",
    "f_larglist : f_args",
    "lambda_body : tLAMBEG compstmt tRCURLY",
    "lambda_body : keyword_do_lambda compstmt keyword_end",
    "$$27 :",
    "do_block : keyword_do_block $$27 opt_block_param compstmt keyword_end",
    "block_call : command do_block",
    "block_call : block_call call_op2 operation2 opt_paren_args",
    "block_call : block_call call_op2 operation2 opt_paren_args brace_block",
    "block_call : block_call call_op2 operation2 command_args do_block",
    "method_call : fcall paren_args",
    "method_call : primary_value call_op operation2 opt_paren_args",
    "method_call : primary_value tCOLON2 operation2 paren_args",
    "method_call : primary_value tCOLON2 operation3",
    "method_call : primary_value call_op paren_args",
    "method_call : primary_value tCOLON2 paren_args",
    "method_call : keyword_super paren_args",
    "method_call : keyword_super",
    "method_call : primary_value '[' opt_call_args rbracket",
    "$$28 :",
    "brace_block : tLCURLY $$28 opt_block_param compstmt tRCURLY",
    "$$29 :",
    "brace_block : keyword_do $$29 opt_block_param compstmt keyword_end",
    "case_body : keyword_when args then compstmt cases",
    "cases : opt_else",
    "cases : case_body",
    "opt_rescue : keyword_rescue exc_list exc_var then compstmt opt_rescue",
    "opt_rescue :",
    "exc_list : arg_value",
    "exc_list : mrhs",
    "exc_list : none",
    "exc_var : tASSOC lhs",
    "exc_var : none",
    "opt_ensure : keyword_ensure compstmt",
    "opt_ensure : none",
    "literal : numeric",
    "literal : symbol",
    "literal : dsym",
    "strings : string",
    "string : tCHAR",
    "string : string1",
    "string : string string1",
    "string1 : tSTRING_BEG string_contents tSTRING_END",
    "xstring : tXSTRING_BEG xstring_contents tSTRING_END",
    "regexp : tREGEXP_BEG regexp_contents tREGEXP_END",
    "words : tWORDS_BEG ' ' tSTRING_END",
    "words : tWORDS_BEG word_list tSTRING_END",
    "word_list :",
    "word_list : word_list word ' '",
    "word : string_content",
    "word : word string_content",
    "symbols : tSYMBOLS_BEG ' ' tSTRING_END",
    "symbols : tSYMBOLS_BEG symbol_list tSTRING_END",
    "symbol_list :",
    "symbol_list : symbol_list word ' '",
    "qwords : tQWORDS_BEG ' ' tSTRING_END",
    "qwords : tQWORDS_BEG qword_list tSTRING_END",
    "qsymbols : tQSYMBOLS_BEG ' ' tSTRING_END",
    "qsymbols : tQSYMBOLS_BEG qsym_list tSTRING_END",
    "qword_list :",
    "qword_list : qword_list tSTRING_CONTENT ' '",
    "qsym_list :",
    "qsym_list : qsym_list tSTRING_CONTENT ' '",
    "string_contents :",
    "string_contents : string_contents string_content",
    "xstring_contents :",
    "xstring_contents : xstring_contents string_content",
    "regexp_contents :",
    "regexp_contents : regexp_contents string_content",
    "string_content : tSTRING_CONTENT",
    "$$30 :",
    "string_content : tSTRING_DVAR $$30 string_dvar",
    "$$31 :",
    "$$32 :",
    "$$33 :",
    "$$34 :",
    "$$35 :",
    "string_content : tSTRING_DBEG $$31 $$32 $$33 $$34 $$35 compstmt tSTRING_DEND",
    "string_dvar : tGVAR",
    "string_dvar : tIVAR",
    "string_dvar : tCVAR",
    "string_dvar : backref",
    "symbol : tSYMBEG sym",
    "sym : fname",
    "sym : tIVAR",
    "sym : tGVAR",
    "sym : tCVAR",
    "dsym : tSYMBEG xstring_contents tSTRING_END",
    "numeric : simple_numeric",
    "numeric : tUMINUS_NUM simple_numeric",
    "simple_numeric : tINTEGER",
    "simple_numeric : tFLOAT",
    "simple_numeric : tRATIONAL",
    "simple_numeric : tIMAGINARY",
    "var_ref : tIDENTIFIER",
    "var_ref : tIVAR",
    "var_ref : tGVAR",
    "var_ref : tCONSTANT",
    "var_ref : tCVAR",
    "var_ref : keyword_nil",
    "var_ref : keyword_self",
    "var_ref : keyword_true",
    "var_ref : keyword_false",
    "var_ref : keyword__FILE__",
    "var_ref : keyword__LINE__",
    "var_ref : keyword__ENCODING__",
    "var_lhs : tIDENTIFIER",
    "var_lhs : tIVAR",
    "var_lhs : tGVAR",
    "var_lhs : tCONSTANT",
    "var_lhs : tCVAR",
    "var_lhs : keyword_nil",
    "var_lhs : keyword_self",
    "var_lhs : keyword_true",
    "var_lhs : keyword_false",
    "var_lhs : keyword__FILE__",
    "var_lhs : keyword__LINE__",
    "var_lhs : keyword__ENCODING__",
    "backref : tNTH_REF",
    "backref : tBACK_REF",
    "$$36 :",
    "superclass : tLT $$36 expr_value term",
    "superclass :",
    "f_arglist : tLPAREN2 f_args rparen",
    "$$37 :",
    "f_arglist : $$37 f_args term",
    "args_tail : f_kwarg ',' f_kwrest opt_f_block_arg",
    "args_tail : f_kwarg opt_f_block_arg",
    "args_tail : f_kwrest opt_f_block_arg",
    "args_tail : f_block_arg",
    "opt_args_tail : ',' args_tail",
    "opt_args_tail :",
    "f_args : f_arg ',' f_optarg ',' f_rest_arg opt_args_tail",
    "f_args : f_arg ',' f_optarg ',' f_rest_arg ',' f_arg opt_args_tail",
    "f_args : f_arg ',' f_optarg opt_args_tail",
    "f_args : f_arg ',' f_optarg ',' f_arg opt_args_tail",
    "f_args : f_arg ',' f_rest_arg opt_args_tail",
    "f_args : f_arg ',' f_rest_arg ',' f_arg opt_args_tail",
    "f_args : f_arg opt_args_tail",
    "f_args : f_optarg ',' f_rest_arg opt_args_tail",
    "f_args : f_optarg ',' f_rest_arg ',' f_arg opt_args_tail",
    "f_args : f_optarg opt_args_tail",
    "f_args : f_optarg ',' f_arg opt_args_tail",
    "f_args : f_rest_arg opt_args_tail",
    "f_args : f_rest_arg ',' f_arg opt_args_tail",
    "f_args : args_tail",
    "f_args :",
    "f_bad_arg : tCONSTANT",
    "f_bad_arg : tIVAR",
    "f_bad_arg : tGVAR",
    "f_bad_arg : tCVAR",
    "f_norm_arg : f_bad_arg",
    "f_norm_arg : tIDENTIFIER",
    "f_arg_asgn : f_norm_arg",
    "f_arg_item : f_arg_asgn",
    "f_arg_item : tLPAREN f_margs rparen",
    "f_arg : f_arg_item",
    "f_arg : f_arg ',' f_arg_item",
    "f_label : tLABEL",
    "f_kw : f_label arg_value",
    "f_kw : f_label",
    "f_block_kw : f_label primary_value",
    "f_block_kw : f_label",
    "f_block_kwarg : f_block_kw",
    "f_block_kwarg : f_block_kwarg ',' f_block_kw",
    "f_kwarg : f_kw",
    "f_kwarg : f_kwarg ',' f_kw",
    "kwrest_mark : tPOW",
    "kwrest_mark : tDSTAR",
    "f_kwrest : kwrest_mark tIDENTIFIER",
    "f_kwrest : kwrest_mark",
    "f_opt : f_arg_asgn '=' arg_value",
    "f_block_opt : f_arg_asgn '=' primary_value",
    "f_block_optarg : f_block_opt",
    "f_block_optarg : f_block_optarg ',' f_block_opt",
    "f_optarg : f_opt",
    "f_optarg : f_optarg ',' f_opt",
    "restarg_mark : tSTAR2",
    "restarg_mark : tSTAR",
    "f_rest_arg : restarg_mark tIDENTIFIER",
    "f_rest_arg : restarg_mark",
    "blkarg_mark : tAMPER2",
    "blkarg_mark : tAMPER",
    "f_block_arg : blkarg_mark tIDENTIFIER",
    "opt_f_block_arg : ',' f_block_arg",
    "opt_f_block_arg :",
    "singleton : var_ref",
    "$$38 :",
    "singleton : tLPAREN2 $$38 expr rparen",
    "assoc_list : none",
    "assoc_list : assocs trailer",
    "assocs : assoc",
    "assocs : assocs ',' assoc",
    "assoc : arg_value tASSOC arg_value",
    "assoc : tLABEL arg_value",
    "assoc : tSTRING_BEG string_contents tLABEL_END arg_value",
    "assoc : tDSTAR arg_value",
    "operation : tIDENTIFIER",
    "operation : tCONSTANT",
    "operation : tFID",
    "operation2 : tIDENTIFIER",
    "operation2 : tCONSTANT",
    "operation2 : tFID",
    "operation2 : op",
    "operation3 : tIDENTIFIER",
    "operation3 : tFID",
    "operation3 : op",
    "dot_or_colon : tDOT",
    "dot_or_colon : tCOLON2",
    "call_op : tDOT",
    "call_op : tANDDOT",
    "call_op2 : call_op",
    "call_op2 : tCOLON2",
    "opt_terms :",
    "opt_terms : terms",
    "opt_nl :",
    "opt_nl : '\\n'",
    "rparen : opt_nl tRPAREN",
    "rbracket : opt_nl tRBRACK",
    "trailer :",
    "trailer : '\\n'",
    "trailer : ','",
    "term : ';'",
    "term : '\\n'",
    "terms : term",
    "terms : terms ';'",
    "none :",
    "none_block_pass :",
    };

  protected org.jruby.parser.YYDebug yydebug;

  /** index-checked interface to {@link #yyNames}.
      @param token single character or <tt>%token</tt> value.
      @return token name or <tt>[illegal]</tt> or <tt>[unknown]</tt>.
    */
  public static final String yyName (int token) {
    if (token < 0 || token > yyNames.length) return "[illegal]";
    String name;
    if ((name = yyNames[token]) != null) return name;
    return "[unknown]";
  }


  /** computes list of expected tokens on error by tracing the tables.
      @param state for which to compute the list.
      @return list of token names.
    */
  protected String[] yyExpecting (int state) {
    int token, n, len = 0;
    boolean[] ok = new boolean[yyNames.length];

    if ((n = yySindex[state]) != 0)
      for (token = n < 0 ? -n : 0;
           token < yyNames.length && n+token < yyTable.length; ++ token)
        if (yyCheck[n+token] == token && !ok[token] && yyNames[token] != null) {
          ++ len;
          ok[token] = true;
        }
    if ((n = yyRindex[state]) != 0)
      for (token = n < 0 ? -n : 0;
           token < yyNames.length && n+token < yyTable.length; ++ token)
        if (yyCheck[n+token] == token && !ok[token] && yyNames[token] != null) {
          ++ len;
          ok[token] = true;
        }

    String result[] = new String[len];
    for (n = token = 0; n < len;  ++ token)
      if (ok[token]) result[n++] = yyNames[token];
    return result;
  }

  /** the generated parser, with debugging messages.
      Maintains a dynamic state and value stack.
      @param yyLex scanner.
      @param ayydebug debug message writer implementing <tt>yyDebug</tt>, or <tt>null</tt>.
      @return result of the last reduction, if any.
    */
  public Object yyparse (RipperLexer yyLex, Object ayydebug)
				throws java.io.IOException {
    this.yydebug = (org.jruby.parser.YYDebug)ayydebug;
    return yyparse(yyLex);
  }

  /** initial size and increment of the state/value stack [default 256].
      This is not final so that it can be overwritten outside of invocations
      of {@link #yyparse}.
    */
  protected int yyMax;

  /** executed at the beginning of a reduce action.
      Used as <tt>$$ = yyDefault($1)</tt>, prior to the user-specified action, if any.
      Can be overwritten to provide deep copy, etc.
      @param first value for <tt>$1</tt>, or <tt>null</tt>.
      @return first.
    */
  protected Object yyDefault (Object first) {
    return first;
  }

  /** the generated parser.
      Maintains a dynamic state and value stack.
      @param yyLex scanner.
      @return result of the last reduction, if any.
    */
  public Object yyparse (RipperLexer yyLex) throws java.io.IOException {
    if (yyMax <= 0) yyMax = 256;			// initial size
    int yyState = 0, yyStates[] = new int[yyMax];	// state stack
    Object yyVal = null, yyVals[] = new Object[yyMax];	// value stack
    int yyToken = -1;					// current input
    int yyErrorFlag = 0;				// #tokens to shift

    yyLoop: for (int yyTop = 0;; ++ yyTop) {
      if (yyTop >= yyStates.length) {			// dynamically increase
        int[] i = new int[yyStates.length+yyMax];
        System.arraycopy(yyStates, 0, i, 0, yyStates.length);
        yyStates = i;
        Object[] o = new Object[yyVals.length+yyMax];
        System.arraycopy(yyVals, 0, o, 0, yyVals.length);
        yyVals = o;
      }
      yyStates[yyTop] = yyState;
      yyVals[yyTop] = yyVal;
      if (yydebug != null) yydebug.push(yyState, yyVal);

      yyDiscarded: for (;;) {	// discarding a token does not change stack
        int yyN;
        if ((yyN = yyDefRed[yyState]) == 0) {	// else [default] reduce (yyN)
          if (yyToken < 0) {
//            yyToken = yyLex.advance() ? yyLex.token() : 0;
            yyToken = yyLex.nextToken();
            if (yydebug != null)
              yydebug.lex(yyState, yyToken, yyName(yyToken), yyLex.value());
          }
          if ((yyN = yySindex[yyState]) != 0 && (yyN += yyToken) >= 0
              && yyN < yyTable.length && yyCheck[yyN] == yyToken) {
            if (yydebug != null)
              yydebug.shift(yyState, yyTable[yyN], yyErrorFlag-1);
            yyState = yyTable[yyN];		// shift to yyN
            yyVal = yyLex.value();
            yyToken = -1;
            if (yyErrorFlag > 0) -- yyErrorFlag;
            continue yyLoop;
          }
          if ((yyN = yyRindex[yyState]) != 0 && (yyN += yyToken) >= 0
              && yyN < yyTable.length && yyCheck[yyN] == yyToken)
            yyN = yyTable[yyN];			// reduce (yyN)
          else
            switch (yyErrorFlag) {
  
            case 0:
              yyerror("syntax error", yyExpecting(yyState), yyNames[yyToken]);
              if (yydebug != null) yydebug.error("syntax error");
  
            case 1: case 2:
              yyErrorFlag = 3;
              do {
                if ((yyN = yySindex[yyStates[yyTop]]) != 0
                    && (yyN += yyErrorCode) >= 0 && yyN < yyTable.length
                    && yyCheck[yyN] == yyErrorCode) {
                  if (yydebug != null)
                    yydebug.shift(yyStates[yyTop], yyTable[yyN], 3);
                  yyState = yyTable[yyN];
                  yyVal = yyLex.value();
                  continue yyLoop;
                }
                if (yydebug != null) yydebug.pop(yyStates[yyTop]);
              } while (-- yyTop >= 0);
              if (yydebug != null) yydebug.reject();
              yyerror("irrecoverable syntax error");
  
            case 3:
              if (yyToken == 0) {
                if (yydebug != null) yydebug.reject();
                yyerror("irrecoverable syntax error at end-of-file");
              }
              if (yydebug != null)
                yydebug.discard(yyState, yyToken, yyName(yyToken),
  							yyLex.value());
              yyToken = -1;
              continue yyDiscarded;		// leave stack alone
            }
        }
        int yyV = yyTop + 1-yyLen[yyN];
        if (yydebug != null)
          yydebug.reduce(yyState, yyStates[yyV-1], yyN, yyRule[yyN], yyLen[yyN]);
        RipperParserState state = states[yyN];
        if (state == null) {
            yyVal = yyDefault(yyV > yyTop ? null : yyVals[yyV]);
        } else {
            yyVal = state.execute(this, yyVal, yyVals, yyTop);
        }
//        switch (yyN) {
// ACTIONS_END
//        }
        yyTop -= yyLen[yyN];
        yyState = yyStates[yyTop];
        int yyM = yyLhs[yyN];
        if (yyState == 0 && yyM == 0) {
          if (yydebug != null) yydebug.shift(0, yyFinal);
          yyState = yyFinal;
          if (yyToken < 0) {
            yyToken = yyLex.nextToken();
//            yyToken = yyLex.advance() ? yyLex.token() : 0;
            if (yydebug != null)
               yydebug.lex(yyState, yyToken,yyName(yyToken), yyLex.value());
          }
          if (yyToken == 0) {
            if (yydebug != null) yydebug.accept(yyVal);
            return yyVal;
          }
          continue yyLoop;
        }
        if ((yyN = yyGindex[yyM]) != 0 && (yyN += yyState) >= 0
            && yyN < yyTable.length && yyCheck[yyN] == yyState)
          yyState = yyTable[yyN];
        else
          yyState = yyDgoto[yyM];
        if (yydebug != null) yydebug.shift(yyStates[yyTop], yyState);
        continue yyLoop;
      }
    }
  }

static RipperParserState[] states = new RipperParserState[648];
static {
states[1] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  p.setState(EXPR_BEG);
                  p.pushLocalScope();
    return yyVal;
  }
};
states[2] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = p.dispatch("on_program", ((IRubyObject)yyVals[0+yyTop]));
                  p.popCurrentScope();
    return yyVal;
  }
};
states[3] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = ((IRubyObject)yyVals[-1+yyTop]);
    return yyVal;
  }
};
states[4] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = p.dispatch("on_stmts_add", p.dispatch("on_stmts_new"), p.dispatch("on_void_stmt"));
    return yyVal;
  }
};
states[5] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = p.dispatch("on_stmts_add", p.dispatch("on_stmts_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[6] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = p.dispatch("on_stmts_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[7] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[9] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  if (p.isInDef() || p.isInSingle()) {
                      p.yyerror("BEGIN in method");
                  }
    return yyVal;
  }
};
states[10] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = p.dispatch("on_BEGIN", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[11] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = p.dispatch("on_bodystmt", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[12] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
    return yyVal;
  }
};
states[13] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_stmts_add", p.dispatch("on_stmts_new"), p.dispatch("on_void_stmt"));
    return yyVal;
  }
};
states[14] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_stmts_add", p.dispatch("on_stmts_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[15] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_stmts_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[16] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[17] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[18] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.yyerror("BEGIN is permitted only at toplevel");
    return yyVal;
  }
};
states[19] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_BEGIN", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[20] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setState(EXPR_FNAME|EXPR_FITEM);
    return yyVal;
  }
};
states[21] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_alias", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[22] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_alias", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[23] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_alias", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[24] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_alias_error", p.dispatch("on_var_alias", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
    return yyVal;
  }
};
states[25] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_undef", ((RubyArray)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[26] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_if_mod", ((IRubyObject)yyVals[0+yyTop]), ((IRubyObject)yyVals[-2+yyTop]));
    return yyVal;
  }
};
states[27] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unless_mod", ((IRubyObject)yyVals[0+yyTop]), ((IRubyObject)yyVals[-2+yyTop]));
    return yyVal;
  }
};
states[28] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_while_mod", ((IRubyObject)yyVals[0+yyTop]), ((IRubyObject)yyVals[-2+yyTop]));
    return yyVal;
  }
};
states[29] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_until_mod", ((IRubyObject)yyVals[0+yyTop]), ((IRubyObject)yyVals[-2+yyTop]));
    return yyVal;
  }
};
states[30] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_rescue_mod", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[31] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    if (p.isInDef() || p.isInSingle()) {
                        p.warn("END in method; use at_exit");
                    }
                    yyVal = p.dispatch("on_END", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[33] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_massign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[34] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[35] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_aref_field", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[36] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[37] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field",((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[38] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[-1+yyTop]),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[39] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[40] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign_error", 
                                    p.dispatch("on_assign", 
                                    p.dispatch("on_var_field", ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
    return yyVal;
  }
};
states[41] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[42] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_massign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[44] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[45] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[47] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("and"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[48] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("or"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[49] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("not"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[50] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("!"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[52] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[56] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_arg", 
                                    p.dispatch("on_call", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[57] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.pushBlockScope();
    return yyVal;
  }
};
states[58] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_brace_block", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
                    p.popCurrentScope();
    return yyVal;
  }
};
states[60] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_command", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[61] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_block",
                                    p.dispatch("on_command", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[62] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_command_call", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[63] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_block",
                                    p.dispatch("on_command_call", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop])); 
    return yyVal;
  }
};
states[64] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_command_call", ((IRubyObject)yyVals[-3+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[65] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_block",
                                    p.dispatch("on_command_call", ((IRubyObject)yyVals[-4+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[66] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_super", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[67] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_yield", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[68] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_return", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[69] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_break", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[70] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_next", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[72] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[74] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[75] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[76] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[77] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[78] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add",
                                    p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[79] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-1+yyTop]), null);
    return yyVal;
  }
};
states[80] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add",
                                    p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-3+yyTop]), null),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[81] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[82] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add",
                                    p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[83] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), null);
    return yyVal;
  }
};
states[84] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add",
                                    p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), null),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[86] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[87] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[88] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[89] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[90] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[91] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[92] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[93] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[94] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.assignable(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[95] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[96] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.compile_error("Can't assign to nil");
                    yyVal = null;
    return yyVal;
  }
};
states[97] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.compile_error("Can't change the value of self");
                    yyVal = null;
    return yyVal;
  }
};
states[98] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.compile_error("Can't assign to true");
                    yyVal = null;
    return yyVal;
  }
};
states[99] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.compile_error("Can't assign to false");
                    yyVal = null;
    return yyVal;
  }
};
states[100] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.compile_error("Can't assign to __FILE__");
                    yyVal = null;
    return yyVal;
  }
};
states[101] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.compile_error("Can't assign to __LINE__");
                    yyVal = null;
    return yyVal;
  }
};
states[102] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.compile_error("Can't assign to __ENCODING__");
                    yyVal = null;
    return yyVal;
  }
};
states[103] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_aref_field", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[104] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
                    
    return yyVal;
  }
};
states[105] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[106] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
		    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[107] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));

                    if (p.isInDef() || p.isInSingle()) {
                        yyVal = p.dispatch("on_assign_error", ((IRubyObject)yyVal));
                        p.error();
                    }
    return yyVal;
  }
};
states[108] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_top_const_field", ((IRubyObject)yyVals[0+yyTop]));

                    if (p.isInDef() || p.isInSingle()) {
                        yyVal = p.dispatch("on_assign_error", ((IRubyObject)yyVal));
                        p.error();
                    }
    return yyVal;
  }
};
states[109] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign_error", p.dispatch("on_var_field", ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
    return yyVal;
  }
};
states[110] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[111] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[112] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[113] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[114] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[115] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[116] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[117] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[118] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[119] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[120] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[121] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[122] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_aref_field", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[123] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[124] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), p.intern("::"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[125] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[126] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    IRubyObject val = p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));

                    if (p.isInDef() || p.isInSingle()) {
                        val = p.dispatch("on_assign_error", val);
                        p.error();
                    }

                    yyVal = val;
    return yyVal;
  }
};
states[127] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    IRubyObject val = p.dispatch("on_top_const_field", ((IRubyObject)yyVals[0+yyTop]));

                    if (p.isInDef() || p.isInSingle()) {
                        val = p.dispatch("on_assign_error", val);
                        p.error();
                    }

                    yyVal = val;
    return yyVal;
  }
};
states[128] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
    return yyVal;
  }
};
states[129] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_class_name_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
    return yyVal;
  }
};
states[131] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_top_const_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[132] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_const_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[133] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_const_path_ref", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[137] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   p.setState(EXPR_ENDFN);
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[138] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   p.setState(EXPR_ENDFN);
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[139] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[140] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[141] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.dispatch("on_symbol_literal", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[142] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[143] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[144] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setState(EXPR_FNAME|EXPR_FITEM);
    return yyVal;
  }
};
states[145] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-3+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[221] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[222] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign", ((IRubyObject)yyVals[-4+yyTop]), p.dispatch("on_rescue_mod", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[223] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[224] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), p.dispatch("on_rescue_mod", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[225] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_aref_field", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[226] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[227] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[228] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_opassign", 
                                    p.dispatch("on_field", ((IRubyObject)yyVals[-4+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-2+yyTop])),
                                    ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[229] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign_error", 
                                    p.dispatch("on_opassign", 
                                               p.dispatch("on_const_path_field", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop])),
                                               ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[230] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign_error", 
                                    p.dispatch("on_opassign", 
                                               p.dispatch("on_top_const_field", ((IRubyObject)yyVals[-2+yyTop])),
                                               ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[231] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assign_error", 
                                    p.dispatch("on_opassign",
                                               p.dispatch("on_var_field", ((IRubyObject)yyVals[-2+yyTop])),
                                               ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop])));
                    p.error();
    return yyVal;
  }
};
states[232] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_dot2", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[233] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_dot3", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[234] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("+"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[235] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("-"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[236] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("*"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[237] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("/"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[238] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("%"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[239] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("**"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[240] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", 
                                    p.intern("-@"), 
                                    p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("**"), ((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[241] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("+@"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[242] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("-@"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[243] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("|"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[244] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("^"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[245] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("&"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[246] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("<=>"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[247] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern(">"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[248] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern(">="), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[249] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("<"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[250] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("<="), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[251] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("=="), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[252] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("==="), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[253] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("!="), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[254] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("=~"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[255] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("!~"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[256] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("!"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[257] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("~"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[258] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("<<"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[259] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern(">>"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[260] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("&&"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[261] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_binary", ((IRubyObject)yyVals[-2+yyTop]), p.intern("||"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[262] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_defined", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[263] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_ifop", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[264] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[265] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[267] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
    return yyVal;
  }
};
states[268] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add", 
                                    ((IRubyObject)yyVals[-3+yyTop]),
                                    p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop])));
    return yyVal;
  }
};
states[269] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add", 
                                    p.dispatch("on_args_new"),
                                    p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop])));
    return yyVal;
  }
};
states[270] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_arg_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[275] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
    return yyVal;
  }
};
states[276] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add", ((IRubyObject)yyVals[-3+yyTop]), p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop])));
    return yyVal;
  }
};
states[277] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add", 
                                    p.dispatch("on_args_new"),
                                    p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop])));
    return yyVal;
  }
};
states[278] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add", p.dispatch("on_args_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[279] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.arg_add_optblock(((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[280] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal =  p.arg_add_optblock(p.dispatch("on_args_add", 
                                                        p.dispatch("on_args_new"),
                                                        p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop]))),
                                             ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[281] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.arg_add_optblock(p.dispatch("on_args_add", 
                                            ((IRubyObject)yyVals[-3+yyTop]),
                                            p.dispatch("on_bare_assoc_hash", ((RubyArray)yyVals[-1+yyTop]))),
                                            ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[282] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add_block", p.dispatch("on_args_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[283] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = Long.valueOf(p.getCmdArgumentState().getStack());
    return yyVal;
  }
};
states[284] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.getCmdArgumentState().reset(((Long)yyVals[-1+yyTop]).longValue());
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[285] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[286] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[288] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add", p.dispatch("on_args_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[289] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add_star", p.dispatch("on_args_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[290] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[291] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_args_add_star", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[292] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[293] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[294] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mrhs_add", 
                                    p.dispatch("on_mrhs_new_from_args", ((IRubyObject)yyVals[-2+yyTop])), 
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[295] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mrhs_add_star",
                                    p.dispatch("on_mrhs_new_from_args", ((IRubyObject)yyVals[-3+yyTop])),
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[296] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mrhs_add_star", p.dispatch("on_mrhs_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[303] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]); /* FIXME: Why complaining without $$ = $1;*/
    return yyVal;
  }
};
states[304] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]); /* FIXME: Why complaining without $$ = $1;*/
    return yyVal;
  }
};
states[307] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_arg", p.dispatch("on_fcall", ((IRubyObject)yyVals[0+yyTop])), p.dispatch("on_args_new"));
    return yyVal;
  }
};
states[308] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.getCmdArgumentState().getStack();
                    p.getCmdArgumentState().reset();
    return yyVal;
  }
};
states[309] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.getCmdArgumentState().reset(((Long)yyVals[-2+yyTop]).longValue());
                    yyVal = p.dispatch("on_begin", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[310] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setState(EXPR_ENDARG);
    return yyVal;
  }
};
states[311] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_paren", null);
    return yyVal;
  }
};
states[312] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.getCmdArgumentState().getStack();
                    p.getCmdArgumentState().reset();
    return yyVal;
  }
};
states[313] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setState(EXPR_ENDARG); 
    return yyVal;
  }
};
states[314] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.getCmdArgumentState().reset(((Long)yyVals[-3+yyTop]).longValue());
                    p.warning("(...) interpreted as grouped expression");
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-2+yyTop]));
    return yyVal;
  }
};
states[315] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[316] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_const_path_ref", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[317] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_top_const_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[318] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[319] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_hash", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[320] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_return0");
    return yyVal;
  }
};
states[321] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_yield", p.dispatch("on_paren", ((IRubyObject)yyVals[-1+yyTop])));
    return yyVal;
  }
};
states[322] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_yield", p.dispatch("on_paren", p.dispatch("on_args_new")));
    return yyVal;
  }
};
states[323] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_yield0");
    return yyVal;
  }
};
states[324] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_defined", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[325] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("not"), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[326] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("not"), null);
    return yyVal;
  }
};
states[327] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_block",
                                    p.dispatch("on_method_add_arg", 
                                               p.dispatch("on_fcall", ((IRubyObject)yyVals[-1+yyTop])), 
                                               p.dispatch("on_args_new")), 
                                    ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[329] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_block", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[330] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[331] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_if", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[332] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unless", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[333] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.getConditionState().begin();
    return yyVal;
  }
};
states[334] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.getConditionState().end();
    return yyVal;
  }
};
states[335] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_while", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[336] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  p.getConditionState().begin();
    return yyVal;
  }
};
states[337] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  p.getConditionState().end();
    return yyVal;
  }
};
states[338] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_until", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[339] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_case", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[340] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_case", null, ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[341] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.getConditionState().begin();
    return yyVal;
  }
};
states[342] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.getConditionState().end();
    return yyVal;
  }
};
states[343] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_for", ((IRubyObject)yyVals[-7+yyTop]), ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[344] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    if (p.isInDef() || p.isInSingle()) {
                        p.yyerror("class definition in method body");
                    }
                    p.pushLocalScope();
    return yyVal;
  }
};
states[345] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_class", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
                    p.popCurrentScope();
    return yyVal;
  }
};
states[346] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = Boolean.valueOf(p.isInDef());
                    p.setInDef(false);
    return yyVal;
  }
};
states[347] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = Integer.valueOf(p.getInSingle());
                    p.setInSingle(0);
                    p.pushLocalScope();
    return yyVal;
  }
};
states[348] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_sclass", ((IRubyObject)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));

                    p.popCurrentScope();
                    p.setInDef(((Boolean)yyVals[-4+yyTop]).booleanValue());
                    p.setInSingle(((Integer)yyVals[-2+yyTop]).intValue());
    return yyVal;
  }
};
states[349] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    if (p.isInDef() || p.isInSingle()) { 
                        p.yyerror("module definition in method body");
                    }
                    p.pushLocalScope();
    return yyVal;
  }
};
states[350] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_module", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
                    p.popCurrentScope();
    return yyVal;
  }
};
states[351] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setInDef(true);
                    p.pushLocalScope();
                    yyVal = p.getCurrentArg();
                    p.setCurrentArg(null);
    return yyVal;
  }
};
states[352] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_def", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));

                    p.popCurrentScope();
                    p.setInDef(false);
                    p.setCurrentArg(((IRubyObject)yyVals[-3+yyTop]));
    return yyVal;
  }
};
states[353] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setState(EXPR_FNAME);
    return yyVal;
  }
};
states[354] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setInSingle(p.getInSingle() + 1);
                    p.pushLocalScope();
                    p.setState(EXPR_ENDFN|EXPR_LABEL); /* force for args */
                    yyVal = p.getCurrentArg();
                    p.setCurrentArg(null);                    
    return yyVal;
  }
};
states[355] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_defs", ((IRubyObject)yyVals[-7+yyTop]), ((IRubyObject)yyVals[-6+yyTop]), ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));

                    p.popCurrentScope();
                    p.setInSingle(p.getInSingle() - 1);
                    p.setCurrentArg(((IRubyObject)yyVals[-3+yyTop]));
    return yyVal;
  }
};
states[356] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_break", p.dispatch("on_args_new"));
    return yyVal;
  }
};
states[357] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_next", p.dispatch("on_args_new"));
    return yyVal;
  }
};
states[358] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_redo");
    return yyVal;
  }
};
states[359] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_retry");
    return yyVal;
  }
};
states[360] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[361] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = null;
    return yyVal;
  }
};
states[363] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[364] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = null;
    return yyVal;
  }
};
states[367] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_elsif", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[369] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_else", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[371] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
    return yyVal;
  }
};
states[372] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_paren", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[373] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[374] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add", p.dispatch("on_mlhs_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[375] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[376] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[377] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-3+yyTop]), p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[378] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-5+yyTop]), p.assignable(((IRubyObject)yyVals[-2+yyTop])));
    return yyVal;
  }
};
states[379] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-2+yyTop]), null);
    return yyVal;
  }
};
states[380] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[381] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[382] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", p.assignable(((IRubyObject)yyVals[-2+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[383] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), null);
    return yyVal;
  }
};
states[384] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_add_star", p.dispatch("on_mlhs_new"), null);
    return yyVal;
  }
};
states[385] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[386] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(((RubyArray)yyVals[-1+yyTop]), null, ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[387] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(null, ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[388] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(null, null, ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[389] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((ArgsTailHolder)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[390] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(null, null, null);
    return yyVal;
  }
};
states[391] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), ((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[392] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-7+yyTop]), ((RubyArray)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[393] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[394] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), ((RubyArray)yyVals[-3+yyTop]), null, ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[395] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-3+yyTop]), null, ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[396] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_excessed_comma", 
                                    p.new_args(((RubyArray)yyVals[-1+yyTop]), null, null, null, null));
    return yyVal;
  }
};
states[397] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), null, ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[398] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-1+yyTop]), null, null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[399] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[400] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[401] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-1+yyTop]), null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[402] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-3+yyTop]), null, ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[403] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, null, ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));     
    return yyVal;
  }
};
states[404] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, null, ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[405] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, null, null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[407] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCommandStart(true);
    return yyVal;
  }
};
states[408] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCurrentArg(null);  
                    yyVal = p.dispatch("on_block_var", 
                                    p.new_args(null, null, null, null, null), 
                                    ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[409] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_block_var", 
                                    p.new_args(null, null, null, null, null), 
                                    null);
    return yyVal;
  }
};
states[410] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCurrentArg(null);
                    yyVal = p.dispatch("on_block_var", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[411] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = null;
    return yyVal;
  }
};
states[412] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-1+yyTop]);
    return yyVal;
  }
};
states[413] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[414] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[415] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_bv(((IRubyObject)yyVals[0+yyTop]));

    return yyVal;
  }
};
states[416] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = null;
    return yyVal;
  }
};
states[417] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.pushBlockScope();
                    yyVal = p.getLeftParenBegin();
                    p.setLeftParenBegin(p.incrementParenNest());
    return yyVal;
  }
};
states[418] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.getCmdArgumentState().getStack();
                    p.getCmdArgumentState().reset();
    return yyVal;
  }
};
states[419] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_lambda", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
                    p.popCurrentScope();
                    p.setLeftParenBegin(((Integer)yyVals[-3+yyTop]));
                    p.getCmdArgumentState().reset(((Long)yyVals[-2+yyTop]).longValue());
    return yyVal;
  }
};
states[420] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-2+yyTop]));
    return yyVal;
  }
};
states[421] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[422] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
    return yyVal;
  }
};
states[423] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
    return yyVal;
  }
};
states[424] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.pushBlockScope();
    return yyVal;
  }
};
states[425] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_do_block", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
                    p.popCurrentScope();
    return yyVal;
  }
};
states[426] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_block", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[427] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[428] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.method_add_block(p.dispatch("on_command_call", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[429] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.method_add_block(p.dispatch("on_command_call", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[430] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_method_add_arg", p.dispatch("on_fcall", ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[431] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[432] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-3+yyTop]), p.intern("::"), ((IRubyObject)yyVals[-1+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[433] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_call", ((IRubyObject)yyVals[-2+yyTop]), p.intern("::"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[434] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), p.intern("call")), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[435] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.method_optarg(p.dispatch("on_call", ((IRubyObject)yyVals[-2+yyTop]), p.intern("::"), p.intern("call")), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[436] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_super", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[437] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_zsuper");
    return yyVal;
  }
};
states[438] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_aref", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[439] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.pushBlockScope();
    return yyVal;
  }
};
states[440] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_brace_block", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
                    p.popCurrentScope();
    return yyVal;
  }
};
states[441] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.pushBlockScope();
    return yyVal;
  }
};
states[442] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_do_block", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
                    p.popCurrentScope();
    return yyVal;
  }
};
states[443] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_when", ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));

    return yyVal;
  }
};
states[446] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_rescue", ((IRubyObject)yyVals[-4+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[447] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = null;
    return yyVal;
  }
};
states[448] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[449] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[451] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[453] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_ensure", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[456] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_symbol_literal", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[458] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[461] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_string_concat", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[462] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.heredoc_dedent(((IRubyObject)yyVals[-1+yyTop]));
                    p.setHeredocIndent(0);
                    yyVal = p.dispatch("on_string_literal", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[463] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.heredoc_dedent(((IRubyObject)yyVals[-1+yyTop]));
                    p.setHeredocIndent(0);
                    yyVal = p.dispatch("on_xstring_literal", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[464] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_regexp_literal", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[465] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", p.dispatch("on_words_new"));
    return yyVal;
  }
};
states[466] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[467] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_words_new");
    return yyVal;
  }
};
states[468] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_words_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[469] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_word_add", p.dispatch("on_word_new"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[470] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_word_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[471] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", p.dispatch("on_symbols_new"));
    return yyVal;
  }
};
states[472] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[473] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_symbols_new");
    return yyVal;
  }
};
states[474] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_symbols_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[475] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", p.dispatch("on_qwords_new"));
    return yyVal;
  }
};
states[476] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[477] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", p.dispatch("on_qsymbols_new"));
    return yyVal;
  }
};
states[478] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_array", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[479] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_qwords_new");
    return yyVal;
  }
};
states[480] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_qwords_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[481] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_qsymbols_new");
    return yyVal;
  }
};
states[482] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_qsymbols_add", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[483] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_string_content");
    return yyVal;
  }
};
states[484] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_string_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[485] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_xstring_new");
    return yyVal;
  }
};
states[486] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_xstring_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[487] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_regexp_new");
    return yyVal;
  }
};
states[488] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_regexp_add", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[490] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.getStrTerm();
                    p.setStrTerm(null);
                    p.setState(EXPR_BEG);
    return yyVal;
  }
};
states[491] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setStrTerm(((StrTerm)yyVals[-1+yyTop]));
                    yyVal = p.dispatch("on_string_dvar", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[492] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.getStrTerm();
                   p.setStrTerm(null);
                   p.getConditionState().stop();
    return yyVal;
  }
};
states[493] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.getCmdArgumentState().getStack();
                   p.getCmdArgumentState().reset();
    return yyVal;
  }
};
states[494] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.getState();
                   p.setState(EXPR_BEG);
    return yyVal;
  }
};
states[495] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.getBraceNest();
                   p.setBraceNest(0);
    return yyVal;
  }
};
states[496] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.getHeredocIndent();
                   p.setHeredocIndent(0);
    return yyVal;
  }
};
states[497] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   p.getConditionState().restart();
                   p.setStrTerm(((StrTerm)yyVals[-6+yyTop]));
                   p.getCmdArgumentState().reset(((Long)yyVals[-5+yyTop]).longValue());
                   p.setState(((Integer)yyVals[-4+yyTop]));
                   p.setBraceNest(((Integer)yyVals[-3+yyTop]));
                   p.setHeredocIndent(((Integer)yyVals[-2+yyTop]));
                   yyVal = p.dispatch("on_string_embexpr", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[498] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[499] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[500] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[502] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                     p.setState(EXPR_END|EXPR_ENDARG);
                     yyVal = p.dispatch("on_symbol", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[507] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                     p.setState(EXPR_END|EXPR_ENDARG);
                     yyVal = p.dispatch("on_dyna_symbol", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[508] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[509] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_unary", p.intern("-@"), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[510] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[511] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[512] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[513] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                     yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[514] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    if (p.is_id_var(((IRubyObject)yyVals[0+yyTop]))) {
                        yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
                    } else {
                        yyVal = p.dispatch("on_vcall", ((IRubyObject)yyVals[0+yyTop]));
                    }
    return yyVal;
  }
};
states[515] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    if (p.is_id_var(((IRubyObject)yyVals[0+yyTop]))) {
                        yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
                    } else {
                        yyVal = p.dispatch("on_vcall", ((IRubyObject)yyVals[0+yyTop]));
                    }
    return yyVal;
  }
};
states[516] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    if (p.is_id_var(((IRubyObject)yyVals[0+yyTop]))) {
                        yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
                    } else {
                        yyVal = p.dispatch("on_vcall", ((IRubyObject)yyVals[0+yyTop]));
                    }
    return yyVal;
  }
};
states[517] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    if (p.is_id_var(((IRubyObject)yyVals[0+yyTop]))) {
                        yyVal = p.dispatch("on_var_ref", p.assignable(((IRubyObject)yyVals[0+yyTop])));
                    } else {
                        yyVal = p.dispatch("on_vcall", p.assignable(((IRubyObject)yyVals[0+yyTop])));
                    }
    return yyVal;
  }
};
states[518] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    if (p.is_id_var(((IRubyObject)yyVals[0+yyTop]))) {
                        yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
                    } else {
                        yyVal = p.dispatch("on_vcall", ((IRubyObject)yyVals[0+yyTop]));
                    }
    return yyVal;
  }
};
states[519] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[520] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[521] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[522] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[523] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[524] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[525] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_ref", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[526] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[527] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[528] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[529] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[530] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[531] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[532] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[533] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[534] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[535] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[536] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[537] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_var_field", p.assignable(((IRubyObject)yyVals[0+yyTop])));
    return yyVal;
  }
};
states[540] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   p.setState(EXPR_BEG);
                   p.setCommandStart(true);
    return yyVal;
  }
};
states[541] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
    return yyVal;
  }
};
states[542] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = null;
    return yyVal;
  }
};
states[543] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setState(EXPR_BEG);
                    p.setCommandStart(true);
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[544] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
  /* $$ = lexer.inKwarg;*/
                   /*                   p.inKwarg = true;*/
                   p.setState(p.getState() | EXPR_LABEL);
    return yyVal;
  }
};
states[545] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
  /* p.inKwarg = $<Boolean>1;*/
                    yyVal = ((IRubyObject)yyVals[-1+yyTop]);
                    p.setState(EXPR_BEG);
                    p.setCommandStart(true);
    return yyVal;
  }
};
states[546] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[547] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(((RubyArray)yyVals[-1+yyTop]), null, ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[548] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(null, ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[549] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(null, null, ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[550] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((ArgsTailHolder)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[551] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args_tail(null, null, null);
    return yyVal;
  }
};
states[552] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), ((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[553] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-7+yyTop]), ((RubyArray)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[554] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[555] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), ((RubyArray)yyVals[-3+yyTop]), null, ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[556] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-3+yyTop]), null, ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[557] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-5+yyTop]), null, ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[558] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(((RubyArray)yyVals[-1+yyTop]), null, null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[559] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-3+yyTop]), ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[560] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-5+yyTop]), ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[561] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-1+yyTop]), null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[562] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, ((RubyArray)yyVals[-3+yyTop]), null, ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[563] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, null, ((IRubyObject)yyVals[-1+yyTop]), null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[564] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, null, ((IRubyObject)yyVals[-3+yyTop]), ((RubyArray)yyVals[-1+yyTop]), ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[565] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, null, null, null, ((ArgsTailHolder)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[566] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_args(null, null, null, null, null);
    return yyVal;
  }
};
states[567] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_param_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
    return yyVal;
  }
};
states[568] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_param_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
    return yyVal;
  }
};
states[569] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_param_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
    return yyVal;
  }
};
states[570] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_param_error", ((IRubyObject)yyVals[0+yyTop]));
                    p.error();
    return yyVal;
  }
};
states[572] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.formal_argument(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[573] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCurrentArg(((IRubyObject)yyVals[0+yyTop]));
                    yyVal = p.arg_var(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[574] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCurrentArg(null);
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[575] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_mlhs_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[576] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[577] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[578] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.arg_var(p.formal_argument(((IRubyObject)yyVals[0+yyTop])));
                    p.setCurrentArg(((IRubyObject)yyVals[0+yyTop]));
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[579] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCurrentArg(null);
                    yyVal = p.keyword_arg(((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[580] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCurrentArg(null);
                    yyVal = p.keyword_arg(((IRubyObject)yyVals[0+yyTop]), p.getContext().getRuntime().getFalse());
    return yyVal;
  }
};
states[581] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.keyword_arg(((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[582] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.keyword_arg(((IRubyObject)yyVals[0+yyTop]), p.getContext().getRuntime().getFalse());
    return yyVal;
  }
};
states[583] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[584] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[585] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[586] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[587] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[588] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[589] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.shadowing_lvar(((IRubyObject)yyVals[0+yyTop]));
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[590] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.internalId();
    return yyVal;
  }
};
states[591] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCurrentArg(null);
                    yyVal = p.new_assoc(p.assignable(((IRubyObject)yyVals[-2+yyTop])), ((IRubyObject)yyVals[0+yyTop]));

    return yyVal;
  }
};
states[592] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setCurrentArg(null);
                    yyVal = p.new_assoc(p.assignable(((IRubyObject)yyVals[-2+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[593] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[594] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[595] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[596] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[599] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.arg_var(p.shadowing_lvar(((IRubyObject)yyVals[0+yyTop])));
                    yyVal = p.dispatch("on_rest_param", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[600] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_rest_param", null);
    return yyVal;
  }
};
states[603] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.arg_var(p.shadowing_lvar(((IRubyObject)yyVals[0+yyTop])));
                    yyVal = p.dispatch("on_blockarg", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[604] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[605] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = null;
    return yyVal;
  }
};
states[606] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[607] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    p.setState(EXPR_BEG);
    return yyVal;
  }
};
states[608] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_paren", ((IRubyObject)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[610] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assoclist_from_args", ((RubyArray)yyVals[-1+yyTop]));
    return yyVal;
  }
};
states[611] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.new_array(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[612] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((RubyArray)yyVals[-2+yyTop]).append(((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[613] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assoc_new", ((IRubyObject)yyVals[-2+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[614] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assoc_new", ((IRubyObject)yyVals[-1+yyTop]), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[615] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assoc_new", p.dispatch("on_dyna_symbol", ((IRubyObject)yyVals[-2+yyTop])), ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[616] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.dispatch("on_assoc_splat", ((IRubyObject)yyVals[0+yyTop]));
    return yyVal;
  }
};
states[627] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[628] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[629] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.intern(".");
    return yyVal;
  }
};
states[630] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = p.intern("&.");
    return yyVal;
  }
};
states[631] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[632] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                   yyVal = p.intern("::");
    return yyVal;
  }
};
states[637] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[638] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                    yyVal = ((IRubyObject)yyVals[0+yyTop]);
    return yyVal;
  }
};
states[646] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                      yyVal = null;
    return yyVal;
  }
};
states[647] = new RipperParserState() {
  @Override public Object execute(RipperParser p, Object yyVal, Object[] yyVals, int yyTop) {
                  yyVal = null;
    return yyVal;
  }
};
}
					// line 2157 "RipperParser.y"
}
					// line 9489 "-"
