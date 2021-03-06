from icrawler.builtin import BingImageCrawler

celebs = ['Aeroplane']

numbers = 500

for celeb in celebs:
    bing_crawler = BingImageCrawler(
        storage={'root_dir': 'img/{}'.format(celeb)})
    bing_crawler.crawl(keyword=celeb, filters=None, offset=0, max_num=numbers)
